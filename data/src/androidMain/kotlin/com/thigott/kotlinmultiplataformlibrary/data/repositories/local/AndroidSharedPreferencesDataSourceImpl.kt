package com.thigott.kotlinmultiplataformlibrary.data.repositories.local

import android.content.Context
import com.thigott.kotlinmultiplataformlibrary.data.repositories.local.SharedPreferencesConstants.SP_NAME
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AndroidSharedPreferencesDataSourceImpl: SharedPreferencesDataSource, KoinComponent {

    private val context by inject<Context>()

    override fun getString(key: String): String? {
        return getSp().getString(key, "")
    }

    override fun putString(key: String, value: String) {
        getSpEditor().putString(key, value).apply()
    }

    private fun getSp() = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    private fun getSpEditor() = getSp().edit()
}

actual fun getSharedPreferencesDataSourceImpl(): SharedPreferencesDataSource {
    return AndroidSharedPreferencesDataSourceImpl()
}