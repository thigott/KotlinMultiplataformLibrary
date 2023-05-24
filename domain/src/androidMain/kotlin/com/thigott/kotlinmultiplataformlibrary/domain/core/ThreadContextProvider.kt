package com.thigott.kotlinmultiplataformlibrary.domain.core

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AndroidThreadContextProvider: ThreadContextProvider {
    override val main: CoroutineContext by lazy { Dispatchers.Main }
    override val io: CoroutineContext by lazy { Dispatchers.IO }
}

actual fun getThreadContextProvider(): ThreadContextProvider = AndroidThreadContextProvider()