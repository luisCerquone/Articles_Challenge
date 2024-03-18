package com.example.startedproject.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import example.startedproject.db.ArticlesAppDatabase

actual class DatabaseDriverFactory() {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = ArticlesAppDatabase.Schema,
            name = "ArticlesAppDatabase.ios.db"
        )
}