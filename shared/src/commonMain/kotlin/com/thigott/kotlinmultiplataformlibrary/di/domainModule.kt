package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.domain.core.getThreadContextProvider
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetKtorTestUseCase
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    single {
        CoroutineScope(context = Dispatchers.Default)
        getThreadContextProvider()
    }

    factory {
        GetKtorTestUseCase(
            scope = get(),
            repository = get()
        )
    }

    factory {
        LoginUseCase(
            scope = get(),
            repository = get()
        )
    }
}