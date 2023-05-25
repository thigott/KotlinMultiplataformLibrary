package com.thigott.kotlinmultiplataformlibrary.data.repositories.local

import android.content.Context
import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.SharedPreferencesConstants.SP_NAME
import com.thigott.kotlinmultiplataformlibrary.domain.repositories.local.SharedPreferencesRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AndroidSharedPreferencesRepositoryImpl: SharedPreferencesRepository, KoinComponent {

    private val context by inject<Context>()

    override fun getString(key: String): String? {
        return getSp().getString(key, "")
    }

    override fun putString(key: String, value: String) {
        getSpEditor().putString(key, value)
    }

    private fun getSp() = context.getSharedPreferences(SP_NAME, 0)
    private fun getSpEditor() = getSp().edit()
}

actual fun getSharedPreferencesRepositoryImpl(): SharedPreferencesRepository {
    return AndroidSharedPreferencesRepositoryImpl()
}