package com.thigott.kotlinmultiplataformlibrary.domain.usecases

import com.thigott.kotlinmultiplataformlibrary.domain.core.UseCase
import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.AuthRepository
import kotlinx.coroutines.CoroutineScope

class LoginUseCase(
    scope: CoroutineScope,
    private val repository: AuthRepository
) : UseCase<UserModel, LoginUseCase.Params>(scope = scope) {

    data class Params(
        val username: String,
        val password: String
    )

    override suspend fun run(params: Params?) = when (params) {
        null -> throw NullPointerException()
        else -> repository.login(username = params.username, password = params.password)
    }
}