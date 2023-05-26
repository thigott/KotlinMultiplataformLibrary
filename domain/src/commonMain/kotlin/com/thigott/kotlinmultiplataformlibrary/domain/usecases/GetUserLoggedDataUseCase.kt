package com.thigott.kotlinmultiplataformlibrary.domain.usecases

import com.thigott.kotlinmultiplataformlibrary.domain.core.UseCase
import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetUserLoggedDataUseCase(
    scope: CoroutineScope,
    private val repository: UserRepository
): UseCase<UserModel, Unit>(scope = scope) {

    override fun run(params: Unit?): Flow<UserModel> = repository.getUserLoggedData()
}