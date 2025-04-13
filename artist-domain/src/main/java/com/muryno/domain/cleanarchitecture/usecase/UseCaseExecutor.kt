package com.muryno.domain.cleanarchitecture.usecase

import com.muryno.domain.cleanarchitecture.exception.DomainException
import com.muryno.domain.cleanarchitecture.exception.NetworkDomainException
import com.muryno.domain.cleanarchitecture.exception.UnknownDomainException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException
import kotlin.coroutines.cancellation.CancellationException

class UseCaseExecutor(
    private val coroutineScope: CoroutineScope
) {

    fun <INPUT, OUTPUT> execute(
        useCase: UseCase<INPUT, OUTPUT>,
        value: INPUT,
        onSuccess: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        coroutineScope.launch {
            try {
                useCase.execute(value, onSuccess)
            } catch (throwable: Throwable) {
                when (throwable) {
                    is CancellationException -> throw throwable
                    is DomainException -> onException(throwable)
                    is SSLHandshakeException -> onException(
                        NetworkDomainException("SSL Handshake failed: ${throwable.message}")
                    )
                    is UnknownHostException -> onException(
                        NetworkDomainException("Network error: Host not found")
                    )
                    else -> onException(
                        UnknownDomainException("Unexpected error: ${throwable.message ?: "Unknown error"}")
                    )
                }
            }
        }
    }
}
