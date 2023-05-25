package com.thigott.kotlinmultiplataformlibrary.data.repositories.local

import com.thigott.kotlinmultiplataformlibrary.domain.repositories.local.SharedPreferencesRepository
import platform.Foundation.NSUserDefaults

class IOSSharedPreferencesRepositoryImpl: SharedPreferencesRepository {
    override fun getString(key: String): String? {
        return NSUserDefaults.standardUserDefaults().stringForKey(key)
    }

    override fun putString(key: String, value: String) {
        NSUserDefaults.standardUserDefaults.setObject(value = value, forKey = key)
    }
}

actual fun getSharedPreferencesRepositoryImpl(): SharedPreferencesRepository {
    return IOSSharedPreferencesRepositoryImpl()
}