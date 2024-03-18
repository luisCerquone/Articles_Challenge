package com.example.startedproject.users.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserService(private val httpClient: HttpClient) {

    companion object {
        const val URL =
            "https://jsonplaceholder.org/users"
    }

    suspend fun fetchUsers(): List<UserRaw> {
        return httpClient.get(URL)
            .body<List<UserRaw>>()
    }
}