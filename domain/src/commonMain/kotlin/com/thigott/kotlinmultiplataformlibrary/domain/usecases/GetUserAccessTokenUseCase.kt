package com.thigott.kotlinmultiplataformlibrary.domain.usecases

import com.thigott.kotlinmultiplataformlibrary.domain.repositories.local.UserSessionRepository

class GetUserAccessTokenUseCase(
    private val repository: UserSessionRepository
) {

    operator fun invoke(
        onSuccess: (String) -> Unit = {},
        onError: (Throwable) -> Unit = {}
    ) {
        try {
            val accessToken = repository.getUserAccessToken()
            if (accessToken.isEmpty()) {
                onError.invoke(NullPointerException())
            } else {
                onSuccess.invoke(accessToken)
            }
        } catch (e: Exception) {
            onError.invoke(e)
        }
    }
}