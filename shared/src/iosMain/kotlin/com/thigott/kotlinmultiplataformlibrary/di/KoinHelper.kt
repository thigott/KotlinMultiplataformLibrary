package com.thigott.kotlinmultiplataformlibrary.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            listOf(
                domainModule,
                dataModule
            )
        )
    }
}