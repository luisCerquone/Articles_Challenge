package com.example.startedproject.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import example.startedproject.db.ArticlesAppDatabase

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = ArticlesAppDatabase.Schema,
            context = context,
            name = "ArticlesAppDatabase.android.db"
        )
}