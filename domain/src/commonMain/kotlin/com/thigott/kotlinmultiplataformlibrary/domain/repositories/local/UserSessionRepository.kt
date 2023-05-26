package com.thigott.kotlinmultiplataformlibrary.domain.repositories.local

interface UserSessionRepository {

    fun getUserAccessToken(): String
}