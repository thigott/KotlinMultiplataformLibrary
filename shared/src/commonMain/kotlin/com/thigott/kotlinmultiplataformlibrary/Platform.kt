package com.thigott.kotlinmultiplataformlibrary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform