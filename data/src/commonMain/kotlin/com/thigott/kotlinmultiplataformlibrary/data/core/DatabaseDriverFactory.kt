package com.thigott.kotlinmultiplataformlibrary.data.core

import com.squareup.sqldelight.db.SqlDriver

interface DatabaseDriverFactory {

    fun createDriver(): SqlDriver
}

expect fun getDatabaseDriver(): SqlDriver