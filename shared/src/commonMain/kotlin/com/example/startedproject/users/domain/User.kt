package com.example.startedproject.users.domain

data class User(
    val idUser: Int,
    val name: String,
    val lastName: String,
    val email: String,
    val birthDate: String,
    val address: Address
)