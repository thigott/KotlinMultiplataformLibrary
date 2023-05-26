package com.thigott.kotlinmultiplataformlibrary.data.repositories.remote

import com.thigott.kotlinmultiplataformlibrary.data.core.AuthConstants.LOGIN_URL
import com.thigott.kotlinmultiplataformlibrary.data.core.wrapperGenericResponse
import com.thigott.kotlinmultiplataformlibrary.data.mappers.login.toDomain
import com.thigott.kotlinmultiplataformlibrary.data.models.core.GenericResponse
import com.thigott.kotlinmultiplataformlibrary.data.models.login.LoginRequest
import com.thigott.kotlinmultiplataformlibrary.data.models.login.LoginResponse
import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.SharedPreferencesConstants.SP_USER_ACCESS_TOKEN_KEY
import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.SharedPreferencesDataSource
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote.AuthRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val remoteDataSource: HttpClient,
    private val localDataSource: SharedPreferencesDataSource
) : AuthRepository {

    override fun login(
        username: String,
        password: String
    ) = flow {
        val user = wrapperGenericResponse {
            remoteDataSource.post(LOGIN_URL) {
                setBody(
                    LoginRequest(
                        username = username,
                        password = password,
                        deviceId = ""
                    )
                )
            }.body<GenericResponse<LoginResponse>>()
        }.toDomain()

        if (user.accessToken.isNotEmpty()) {
            saveUserAccessToken(value = user.accessToken)
        }

        emit(user)
    }

    private fun saveUserAccessToken(value: String) {
        localDataSource.putString(
            key = SP_USER_ACCESS_TOKEN_KEY,
            value = value
        )
    }
}