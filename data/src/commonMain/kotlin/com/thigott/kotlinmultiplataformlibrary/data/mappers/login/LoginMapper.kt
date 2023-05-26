package com.thigott.kotlinmultiplataformlibrary.data.mappers.login

import com.thigott.kotlinmultiplataformlibrary.data.models.login.LoginResponse
import com.thigott.kotlinmultiplataformlibrary.domain.models.UserSessionModel

fun LoginResponse.toDomain() = UserSessionModel(
    accessToken = accessToken ?: ""
)