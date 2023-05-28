package com.muryno.domain.cleanarchitecture.usecase

import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import kotlinx.coroutines.withContext

abstract class BackgroundUseCaseExecutor<REQUEST, RESULT>(
    private val coroutineContextProvider: CoroutineContextProvider
) : UseCase<REQUEST, RESULT> {
    final override suspend fun execute(
        input: REQUEST,
        onResult: (RESULT) -> Unit
    ) {
        val result = withContext(coroutineContextProvider.io) {
            executeInBackground(input)
        }
        onResult(result)
    }

    abstract suspend fun executeInBackground(
        request: REQUEST
    ): RESULT
}
