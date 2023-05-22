package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.data.repositories.remote.AuthRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.data.repositories.remote.KtorTestRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.AuthRepository
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.KtorTestRepository
import com.thigott.kotlinmultiplataformlibrary.utils.createHttpClient
import com.thigott.kotlinmultiplataformlibrary.utils.defaultConfig
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {

    single {
        createHttpClient()
    }

    single<KtorTestRepository> {
        KtorTestRepositoryImpl(
            httpClient = get<HttpClient>().config {
                defaultConfig()
            }
        )
    }

    single<AuthRepository> {
        AuthRepositoryImpl(
            httpClient = get<HttpClient>().config {
                defaultConfig()
            }
        )
    }
}