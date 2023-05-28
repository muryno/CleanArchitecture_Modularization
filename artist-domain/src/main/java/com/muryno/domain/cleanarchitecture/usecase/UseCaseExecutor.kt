package com.muryno.domain.cleanarchitecture.usecase

import com.muryno.domain.cleanarchitecture.exception.DomainException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
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
                onException(
                    (throwable as DomainException)
                )
            }
        }
    }
}
