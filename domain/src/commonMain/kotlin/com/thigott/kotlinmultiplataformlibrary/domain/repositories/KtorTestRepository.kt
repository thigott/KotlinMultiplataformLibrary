package com.thigott.kotlinmultiplataformlibrary.domain.repositories

import kotlinx.coroutines.flow.Flow

interface KtorTestRepository {

    suspend fun getKtorTest(): Flow<String>
}