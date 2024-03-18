package com.example.startedproject.users.presentation

import com.example.startedproject.users.domain.User

data class UserState(
    val users: List<User> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)