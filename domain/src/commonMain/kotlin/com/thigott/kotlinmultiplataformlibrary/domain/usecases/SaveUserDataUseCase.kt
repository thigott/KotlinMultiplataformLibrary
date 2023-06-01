package com.thigott.kotlinmultiplataformlibrary.domain.usecases

import com.thigott.kotlinmultiplataformlibrary.domain.core.UseCase
import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SaveUserDataUseCase(
    scope: CoroutineScope,
    private val repository: UserRepository
): UseCase<Unit, UserModel>(scope = scope) {

    override fun run(params: UserModel?): Flow<Unit> = when (params) {
        null -> throw NullPointerException()
        else -> flowOf(repository.saveUserData(userModel = params))
    }
}