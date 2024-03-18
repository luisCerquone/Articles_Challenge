package com.example.startedproject.di

import com.example.startedproject.articles.di.articlesModule
import com.example.startedproject.users.di.userModule

val sharedKoinModules = listOf(
    articlesModule,
    userModule,
    networkModule
)