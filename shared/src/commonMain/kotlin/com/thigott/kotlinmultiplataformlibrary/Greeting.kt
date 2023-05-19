package com.thigott.kotlinmultiplataformlibrary

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello Library, ${platform.name}!"
    }
}