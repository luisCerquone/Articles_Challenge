package com.example.startedproject.users.di

import com.example.startedproject.users.data.UserRepository
import com.example.startedproject.users.data.UserService
import com.example.startedproject.users.domain.UserUseCase
import com.example.startedproject.users.presentation.UserViewModel
import org.koin.dsl.module

val userModule = module {

    single<UserService> { UserService(get()) }
    single<UserUseCase> { UserUseCase(get()) }
    single<UserViewModel> { UserViewModel(get()) }
    single<UserRepository> { UserRepository(get()) }
}