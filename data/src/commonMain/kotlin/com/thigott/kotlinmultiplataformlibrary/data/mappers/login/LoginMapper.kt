package com.thigott.kotlinmultiplataformlibrary.data.mappers.login

import com.thigott.kotlinmultiplataformlibrary.data.models.login.LoginResponse
import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel

fun LoginResponse.toDomain() = UserModel(
    accessToken = accessToken ?: ""
)