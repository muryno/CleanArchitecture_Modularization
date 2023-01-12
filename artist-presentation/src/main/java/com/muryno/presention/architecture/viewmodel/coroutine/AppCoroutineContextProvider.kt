package com.muryno.presention.architecture.viewmodel.coroutine

import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers

class AppCoroutineContextProvider : CoroutineContextProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
}
