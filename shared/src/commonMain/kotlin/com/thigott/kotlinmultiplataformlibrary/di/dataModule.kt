package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.UserSessionRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.getSharedPreferencesDataSourceImpl
import com.thigott.kotlinmultiplataformlibrary.data.repositories.remote.AuthRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.data.repositories.remote.KtorTestRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.local.UserSessionRepository
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote.AuthRepository
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote.KtorTestRepository
import com.thigott.kotlinmultiplataformlibrary.utils.createHttpClient
import com.thigott.kotlinmultiplataformlibrary.utils.defaultConfig
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {

    single {
        createHttpClient(
            getUserAccessTokenUseCase = get()
        )
    }

    single {
        getSharedPreferencesDataSourceImpl()
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
            remoteDataSource = get<HttpClient>().config {
                defaultConfig()
            },
            localDataSource = get()
        )
    }

    single<UserSessionRepository> {
        UserSessionRepositoryImpl(
            localDataSource = get()
        )
    }
}