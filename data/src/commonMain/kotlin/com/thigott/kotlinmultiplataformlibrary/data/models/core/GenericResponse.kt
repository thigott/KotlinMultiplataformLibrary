package com.thigott.kotlinmultiplataformlibrary.data.models.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenericResponse<T>(
    @SerialName("result") val data: T? = null,
    @SerialName("errors") val errors: List<String>? = null,
    @SerialName("success") val success: Boolean = false
)
