package com.thigott.kotlinmultiplataformlibrary.domain.core

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent

abstract class UseCase<T, in Params>(private val scope: CoroutineScope): KoinComponent {

    abstract fun run(params: Params? = null): Flow<T>

    operator fun invoke(
        params: Params? = null,
        onError: ((Throwable) -> Unit) = {},
        onSuccess: (T) -> Unit = {}
    ) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            onError.invoke(throwable)
        }

        scope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            try {
                run(params).collect {
                    withContext(Dispatchers.Main) {
                        onSuccess(it)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }
    }

    fun cancel() = scope.coroutineContext.cancelChildren()
}