package com.thigott.kotlinmultiplataformlibrary.domain.core

import kotlin.coroutines.CoroutineContext

interface ThreadContextProvider {
    val main: CoroutineContext
    val io: CoroutineContext
}

expect fun getThreadContextProvider(): ThreadContextProvider