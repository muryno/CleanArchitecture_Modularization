package com.muryno.data.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext


class DispatchersCoroutineContextProvider :
    CoroutineContextProvider {
    override val main: CoroutineContext by lazy { Dispatchers.Main }
    override val io: CoroutineContext by lazy { Dispatchers.IO }
}
