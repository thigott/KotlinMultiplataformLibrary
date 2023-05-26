package com.thigott.kotlinmultiplataformlibrary.data.repositories.local

interface SharedPreferencesDataSource {

    fun getString(key: String): String?
    fun putString(key: String, value: String)
}