package com.thigott.kotlinmultiplataformlibrary.domain.usecases

import com.thigott.kotlinmultiplataformlibrary.domain.core.UseCase
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.KtorTestRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetKtorTestUseCase(
    scope: CoroutineScope,
    private val repository: KtorTestRepository
): UseCase<String, Unit>(scope = scope) {

    override fun run(params: Unit?): Flow<String> = repository.getKtorTest()
}