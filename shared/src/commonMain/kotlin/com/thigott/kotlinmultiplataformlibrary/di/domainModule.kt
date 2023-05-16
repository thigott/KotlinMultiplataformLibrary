package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetKtorTestUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    single {
        CoroutineScope(Dispatchers.Default)
    }

    factory {
        GetKtorTestUseCase(
            scope = get(),
            repository = get()
        )
    }
}