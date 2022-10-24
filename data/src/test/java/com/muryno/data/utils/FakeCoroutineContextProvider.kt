package com.muryno.data.utils

import kotlin.coroutines.CoroutineContext

private class FakeCoroutineContextProvider(
    override val main: CoroutineContext = fakeCoroutineContext,
    override val io: CoroutineContext = fakeCoroutineContext
) : CoroutineContextProvider

val fakeCoroutineContextProvider: CoroutineContextProvider =
    FakeCoroutineContextProvider()