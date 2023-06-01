package com.thigott.kotlinmultiplataformlibrary.data.core

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.thigott.kotlinmultiplataformlibrary.database.KmmLibraryDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AndroidDatabaseDriverFactory: DatabaseDriverFactory, KoinComponent {

    private val context by inject<Context>()

    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(KmmLibraryDatabase.Schema, context, "user.db")
    }
}

actual fun getDatabaseDriver(): SqlDriver = AndroidDatabaseDriverFactory().createDriver()