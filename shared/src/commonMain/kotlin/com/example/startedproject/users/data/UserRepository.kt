package com.example.startedproject.users.data

class UserRepository(
    private val service: UserService
) {
    suspend fun getUsers(): List<UserRaw> = service.fetchUsers()
}