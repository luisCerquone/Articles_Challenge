package com.example.startedproject.di

import com.example.startedproject.articles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)