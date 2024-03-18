package com.example.startedproject.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.startedproject.db.DatabaseDriverFactory
import example.startedproject.db.ArticlesAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<ArticlesAppDatabase> { ArticlesAppDatabase(get()) }
}