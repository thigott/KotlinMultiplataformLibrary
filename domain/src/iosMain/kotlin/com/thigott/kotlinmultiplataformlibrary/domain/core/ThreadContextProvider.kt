package com.thigott.kotlinmultiplataformlibrary.domain.core

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class IOSThreadContextProvider: ThreadContextProvider {
    override val main: CoroutineContext by lazy { Dispatchers.Main }
    override val io: CoroutineContext by lazy { Dispatchers.Main }
}

actual fun getThreadContextProvider(): ThreadContextProvider = IOSThreadContextProvider()