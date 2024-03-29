package com.example.startedproject.android.di

import com.example.startedproject.articles.presentation.ArticlesViewModel
import com.example.startedproject.users.presentation.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }
    viewModel { UserViewModel(get()) }
}