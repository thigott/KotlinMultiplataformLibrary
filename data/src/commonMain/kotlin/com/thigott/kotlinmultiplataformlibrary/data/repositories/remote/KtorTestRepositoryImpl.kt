package com.thigott.kotlinmultiplataformlibrary.data.repositories.remote

import com.thigott.kotlinmultiplataformlibrary.data.core.KtorTestConstants.GET_KTOR_DOC_URL
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
            httpClient.get(GET_KTOR_DOC_URL).bodyAsText()
        )
    }
}