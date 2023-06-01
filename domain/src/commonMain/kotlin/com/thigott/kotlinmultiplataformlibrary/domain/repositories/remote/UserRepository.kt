package com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote

import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserLoggedData(): Flow<UserModel>

    fun saveUserData(userModel: UserModel)

    fun getUser(id: Int): Flow<UserModel?>
}