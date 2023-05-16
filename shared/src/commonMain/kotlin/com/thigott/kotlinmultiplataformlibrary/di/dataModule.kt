package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.data.repositories.KtorTestRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.KtorTestRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {

    single {
        HttpClient()
    }

    single<KtorTestRepository> {
        KtorTestRepositoryImpl(
            httpClient = get()
        )
    }
}