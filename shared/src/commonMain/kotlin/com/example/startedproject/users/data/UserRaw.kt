package com.example.startedproject.users.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRaw(
    @SerialName("id")
    val idUser: Int,
    @SerialName("firstname")
    val name: String?,
    @SerialName("lastname")
    val lastName: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("birthDate")
    val birthDate: String?,
    @SerialName("address")
    val address: AddressRaw?
)