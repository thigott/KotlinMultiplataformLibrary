package com.thigott.kotlinmultiplataformlibrary.data.core

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.thigott.kotlinmultiplataformlibrary.database.KmmLibraryDatabase

class IOSDatabaseDriverFactory : DatabaseDriverFactory {

    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(KmmLibraryDatabase.Schema, "user.db")
    }
}

actual fun getDatabaseDriver(): SqlDriver = IOSDatabaseDriverFactory().createDriver()