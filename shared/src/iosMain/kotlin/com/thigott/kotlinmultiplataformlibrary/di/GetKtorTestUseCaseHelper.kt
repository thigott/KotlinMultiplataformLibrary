package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetKtorTestUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetKtorTestUseCaseHelper : KoinComponent {

    private val getKtorTestUseCase by inject<GetKtorTestUseCase>()
    fun getKtorTestUseCase(
        success: (String) -> Unit,
        error: (Throwable) -> Unit
    ) = getKtorTestUseCase(
        onSuccess = { success.invoke(it) },
        onError = { error.invoke(it) }
    )
}