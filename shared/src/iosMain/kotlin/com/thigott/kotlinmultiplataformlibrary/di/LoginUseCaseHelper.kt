package com.thigott.kotlinmultiplataformlibrary.di

import com.thigott.kotlinmultiplataformlibrary.domain.models.UserModel
import com.thigott.kotlinmultiplataformlibrary.domain.usecases.LoginUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginUseCaseHelper : KoinComponent {

    private val loginUseCase by inject<LoginUseCase>()
    fun loginUseCase(
        username: String,
        password: String,
        success: (UserModel) -> Unit,
        error: (Throwable) -> Unit
    ) = loginUseCase(
        params = LoginUseCase.Params(
            username = username,
            password = password
        ),
        onSuccess = { success.invoke(it) },
        onError = { error.invoke(it) }
    )
}