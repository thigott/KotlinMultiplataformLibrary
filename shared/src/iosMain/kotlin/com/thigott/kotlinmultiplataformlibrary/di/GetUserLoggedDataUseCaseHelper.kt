package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.GetUserLoggedDataUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetUserLoggedDataUseCaseHelper : KoinComponent {

    private val getUserLoggedDataUseCase by inject<GetUserLoggedDataUseCase>()
    fun getUserLoggedDataUseCase(
        success: (UserModel) -> Unit,
        error: (Throwable) -> Unit
    ) = getUserLoggedDataUseCase(
        onSuccess = { success.invoke(it) },
        onError = { error.invoke(it) }
    )
}