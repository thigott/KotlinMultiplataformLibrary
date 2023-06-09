package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.data.core.getDatabaseDriver
import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.UserSessionRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.getSharedPreferencesDataSourceImpl
import com.thigott.kotlinmultiplataformlibrary.data.repositories.remote.AuthRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.data.repositories.remote.KtorTestRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.data.repositories.remote.UserRepositoryImpl
import com.thigott.kotlinmultiplataformlibrary.data.utils.createHttpClient
import com.thigott.kotlinmultiplataformlibrary.data.utils.defaultConfig
import com.thigott.kotlinmultiplataformlibrary.database.KmmLibraryDatabase
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.local.UserSessionRepository
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote.AuthRepository
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote.KtorTestRepository
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote.UserRepository
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

    single {
        getDatabaseDriver()
    }

    single {
        KmmLibraryDatabase(
            driver = get()
        )
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

    single<UserRepository> {
        UserRepositoryImpl(
            remoteDataSource = get<HttpClient>().config {
                defaultConfig()
            },
            localDataSource = get()
        )
    }
}