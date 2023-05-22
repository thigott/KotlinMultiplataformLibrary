package com.thigott.kotlinmultiplataformlibrary.domain.repositories

import kotlinx.coroutines.flow.Flow

interface KtorTestRepository {

    fun getKtorTest(): Flow<String>
}