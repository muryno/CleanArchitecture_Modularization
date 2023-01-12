package com.muryno.presention.viewmodel

import com.muryno.domain.cleanarchitecture.usecase.UseCase
import com.muryno.domain.cleanarchitecture.usecase.UseCaseExecutor
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.given

private const val ON_SUCCESS_ARGUMENT_INDEX = 2

fun <INPUT, OUTPUT> UseCaseExecutor.givenUseCaseSuccess(
    useCase: UseCase<INPUT, OUTPUT>,
    input: INPUT,
    output: OUTPUT
) {
    given(
        execute(
            useCase = eq(useCase),
            value = eq(input),
            onSuccess = any(),
            onException = any()
        )
    ).willAnswer { invocation ->
        @Suppress("UNCHECKED_CAST")
        val onSuccess = invocation
            .arguments[ON_SUCCESS_ARGUMENT_INDEX] as (OUTPUT) -> Unit
        onSuccess(output)
    }
}
