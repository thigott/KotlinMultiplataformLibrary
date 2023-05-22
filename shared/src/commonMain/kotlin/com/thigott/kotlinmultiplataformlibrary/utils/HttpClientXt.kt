package com.thigott.kotlinmultiplataformlibrary.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.plugin
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.append
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


fun createHttpClient(): HttpClient {
    val client = HttpClient {
        install(Logging) {
            level = LogLevel.ALL
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
    }

    client.plugin(HttpSend).intercept { request ->
        println("interceptor")
        request.headers.append("Content-Type", ContentType.Application.Json)

        execute(request)
    }

    return client
}

fun HttpClientConfig<*>.defaultConfig() {
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = "apigatewaygerenciamento.havan.com.br"
        }
    }
}