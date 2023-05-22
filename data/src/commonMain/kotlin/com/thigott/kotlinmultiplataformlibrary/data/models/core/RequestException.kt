package com.thigott.kotlinmultiplataformlibrary.data.models.core

data class RequestException(
    val errors: List<String> = emptyList()
): Throwable(message = errors.first())
