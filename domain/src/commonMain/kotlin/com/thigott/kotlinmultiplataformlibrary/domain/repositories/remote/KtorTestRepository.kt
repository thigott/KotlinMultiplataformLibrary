package com.thigott.kotlinmultiplataformlibrary.domain.repositories.remote

import kotlinx.coroutines.flow.Flow

interface KtorTestRepository {

    fun getKtorTest(): Flow<String>
}