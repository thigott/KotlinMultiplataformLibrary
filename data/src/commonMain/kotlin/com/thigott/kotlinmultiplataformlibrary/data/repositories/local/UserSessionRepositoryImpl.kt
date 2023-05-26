package com.thigott.kotlinmultiplataformlibrary.data.repositories.local

import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.SharedPreferencesConstants.SP_USER_ACCESS_TOKEN_KEY
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.local.UserSessionRepository

class UserSessionRepositoryImpl(
    private val localDataSource: SharedPreferencesDataSource
): UserSessionRepository {

    override fun getUserAccessToken(): String {
        return localDataSource.getString(key = SP_USER_ACCESS_TOKEN_KEY).orEmpty()
    }
}