package com.thigott.kotlinmultiplataformlibrary.data.models.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("userName") val username: String,
    @SerialName("password") val password: String,
    @SerialName("deviceId") val deviceId: String,
)
