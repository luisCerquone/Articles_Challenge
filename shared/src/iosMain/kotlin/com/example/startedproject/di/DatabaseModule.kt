package com.example.startedproject.di

import app.cash.sqldelight.db.SqlDriver
import com.example.startedproject.db.DatabaseDriverFactory
import example.startedproject.db.ArticlesAppDatabase
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<ArticlesAppDatabase> { ArticlesAppDatabase(get()) }
}