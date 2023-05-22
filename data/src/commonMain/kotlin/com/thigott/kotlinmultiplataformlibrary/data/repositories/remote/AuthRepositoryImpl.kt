package com.thigott.kotlinmultiplataformlibrary.data.repositories.remote

import com.thigott.kotlinmultiplataformlibrary.data.core.AuthConstants.LOGIN_URL
import com.thigott.kotlinmultiplataformlibrary.data.core.wrapperGenericResponse
import com.thigott.kotlinmultiplataformlibrary.data.mappers.login.toDomain
import com.thigott.kotlinmultiplataformlibrary.data.models.core.GenericResponse
import com.thigott.kotlinmultiplataformlibrary.data.models.login.LoginRequest
import com.thigott.kotlinmultiplataformlibrary.data.models.login.LoginResponse
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.AuthRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {

    override suspend fun login(
        username: String,
        password: String
    ) = flow {
        emit(
            wrapperGenericResponse {
                httpClient.post(LOGIN_URL) {
                    setBody(
                        LoginRequest(
                            username = username,
                            password = password,
                            deviceId = ""
                        )
                    )
                    contentType(ContentType.Application.Json)
                }.body<GenericResponse<LoginResponse>>()
            }.toDomain()
        )
    }
}