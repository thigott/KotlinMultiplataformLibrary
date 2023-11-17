package com.thigott.kotlinmultiplataformlibrary.data.utils

import com.thigott.kotlinmultiplataformlibrary.data.core.Core
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetUserAccessTokenUseCase
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


fun createHttpClient(
    getUserAccessTokenUseCase: GetUserAccessTokenUseCase
): HttpClient {
    val client = HttpClient {
        install(Logging) {
            level = LogLevel.ALL
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 60000
            connectTimeoutMillis = 60000
            socketTimeoutMillis = 60000
        }

        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    prettyPrint = true
                    ignoreUnknownKeys = true
                }
            )
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            getUserAccessTokenUseCase(
                onSuccess = {
                    header(HttpHeaders.Authorization, it)
                }
            )
        }
    }

    return client
}

fun HttpClientConfig<*>.defaultConfig() {
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = Core.BASE_URL
        }
    }
}