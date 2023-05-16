package com.thigott.kotlinmultiplataformlibrary.data.repositories

import com.thigott.kotlinmultiplataformlibrary.domain.repositories.KtorTestRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class KtorTestRepositoryImpl(
    private val httpClient: HttpClient
): KtorTestRepository {

    override suspend fun getKtorTest(): Flow<String> = flow {
        emit(
            httpClient.get("https://ktor.io/docs/").bodyAsText()
        )
    }
}