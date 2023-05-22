package com.thigott.kotlinmultiplataformlibrary.data.core

import com.thigott.kotlinmultiplataformlibrary.data.models.core.GenericResponse
import com.thigott.kotlinmultiplataformlibrary.data.models.core.RequestException

suspend fun <T> wrapperGenericResponse(
    call: suspend () -> GenericResponse<T>
): T {
    val result = wrapper(call = call)
    return getGenericResponse(result)
}

suspend fun <D> wrapper(call: suspend () -> D): D {
    return try {
        call().also { result ->
            if (result is GenericResponse<*>) {
                getGenericResponse(result)
            }
        }
    } catch (error: Exception) {
        throw error
    }
}

fun <T> getGenericResponse(result: GenericResponse<T>): T {
    return when {
        result.errors?.isNotEmpty() == true -> throw RequestException(errors = result.errors)
        result.data == null -> throw NullPointerException()
        else -> result.data
    }
}