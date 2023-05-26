package com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote

import com.thigott.kotlinmultiplataformlibrary.domain.models.UserSessionModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun login(username: String, password: String): Flow<UserSessionModel>
}