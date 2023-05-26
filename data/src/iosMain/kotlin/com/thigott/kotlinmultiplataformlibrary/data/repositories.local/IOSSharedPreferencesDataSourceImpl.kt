package com.thigott.kotlinmultiplataformlibrary.data.repositories.local

import platform.Foundation.NSUserDefaults

class IOSSharedPreferencesDataSourceImpl: SharedPreferencesDataSource {
    override fun getString(key: String): String? {
        return NSUserDefaults.standardUserDefaults().stringForKey(key)
    }

    override fun putString(key: String, value: String) {
        NSUserDefaults.standardUserDefaults.setObject(value = value, forKey = key)
    }
}

actual fun getSharedPreferencesDataSourceImpl(): SharedPreferencesDataSource {
    return IOSSharedPreferencesDataSourceImpl()
}