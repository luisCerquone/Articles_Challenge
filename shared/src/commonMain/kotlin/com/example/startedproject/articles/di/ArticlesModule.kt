package com.example.startedproject.articles.di

import com.example.startedproject.articles.ArticlesDataSource
import com.example.startedproject.articles.ArticlesRepository
import com.example.startedproject.articles.ArticlesService
import com.example.startedproject.articles.ArticlesUseCase
import com.example.startedproject.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}