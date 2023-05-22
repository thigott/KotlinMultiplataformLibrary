package com.thigott.kotlinmultiplataformlibrary.domain.repositories

import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun login(username: String, password: String): Flow<UserModel>
}