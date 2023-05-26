package com.thigott.kotlinmultiplataformlibrary.data.repositories.remote

import com.thigott.kotlinmultiplataformlibrary.data.core.UserConstants.GET_LOGGED_USER_DATA
import com.thigott.kotlinmultiplataformlibrary.data.core.wrapperGenericResponse
import com.thigott.kotlinmultiplataformlibrary.data.mappers.user.toDomain
import com.thigott.kotlinmultiplataformlibrary.data.models.core.GenericResponse
import com.thigott.kotlinmultiplataformlibrary.data.models.user.UserLoggedDataResponse
import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote.UserRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(
    private val remoteDataSource: HttpClient
) : UserRepository {
    override fun getUserLoggedData(): Flow<UserModel> = flow {
        emit(
            wrapperGenericResponse {
                remoteDataSource.get(GET_LOGGED_USER_DATA)
                    .body<GenericResponse<UserLoggedDataResponse>>()
            }.toDomain()
        )
    }
}