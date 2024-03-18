package com.example.startedproject.users.domain

import com.example.startedproject.users.data.UserRaw
import com.example.startedproject.users.data.UserRepository

class UserUseCase(private val repository: UserRepository) {

    companion object {
        const val DEFAULT_NAME = "Name unknown"
        const val DEFAULT_LASTNAME = "Lastname unknown"
        const val DEFAULT_EMAIL = "Email unknown"
        const val DEFAULT_BIRTHDATE = "Birthdate unknown"
        const val DEFAULT_LAT = "42.1234"
        const val DEFAULT_LNG = "-71.2345"
    }

    suspend fun getUsers(): List<User> {
        val usersRaw = repository.getUsers()
        return mapUsers(usersRaw)
    }

    private fun mapUsers(usersRaw: List<UserRaw>): List<User> = usersRaw.map { raw ->
        User(
            raw.idUser,
            raw.name ?: DEFAULT_NAME,
            raw.lastName ?: DEFAULT_LASTNAME,
            raw.email ?: DEFAULT_EMAIL,
            raw.birthDate ?: DEFAULT_BIRTHDATE,
            Address(
                Geo(
                    raw.address?.location?.lat ?: DEFAULT_LAT,
                    raw.address?.location?.lng ?: DEFAULT_LNG
                )
            )
        )
    }
}