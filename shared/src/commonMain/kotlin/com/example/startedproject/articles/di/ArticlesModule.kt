package com.example.startedproject.articles.di

import com.example.startedproject.articles.data.ArticlesDataSource
import com.example.startedproject.articles.data.ArticlesRepository
import com.example.startedproject.articles.data.ArticlesService
import com.example.startedproject.articles.domain.ArticlesUseCase
import com.example.startedproject.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}