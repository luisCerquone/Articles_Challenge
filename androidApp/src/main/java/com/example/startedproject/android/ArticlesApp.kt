package com.example.startedproject.android

import android.app.Application
import com.example.startedproject.android.di.viewModelsModule
import com.example.startedproject.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArticlesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@ArticlesApp)
            modules(modules)
        }
    }
}