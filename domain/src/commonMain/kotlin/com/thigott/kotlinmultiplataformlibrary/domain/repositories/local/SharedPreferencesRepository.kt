package com.thigott.kotlinmultiplataformlibrary.domain.repositories.local

interface SharedPreferencesRepository {

    fun getString(key: String): String?
    fun putString(key: String, value: String)
}