package com.thigott.kotlinmultiplataformlibrary.data.models.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName("access_token")
    val accessToken: String? = null,
    @SerialName("token_type")
    val tokenType: String? = null,
    @SerialName("expires_in")
    val tokenExpiresIn: Int? = null,
    @SerialName("refresh_token")
    val refreshToken: String? = null,
    @SerialName("refresh_token_expires_in")
    val refreshTokenExpiresIn: Int? = null,
    @SerialName("deviceIdIsValid")
    val deviceIdIsValid: Boolean? = null,
    @SerialName("access_token_web")
    val accessTokenWeb: String? = null
)
