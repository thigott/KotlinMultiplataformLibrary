package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetKtorTestUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetKtorTestUseCaseHelper : KoinComponent {

    private val getKtorTestUseCase by inject<GetKtorTestUseCase>()
    fun getKtorTestUseCase(
        success: () -> Unit,
        error: () -> Unit
    ) = getKtorTestUseCase(
        onSuccess = { success.invoke() },
        onError = { error.invoke() }
    )
}