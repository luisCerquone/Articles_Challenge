package com.example.startedproject.users.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressRaw(
    @SerialName("geo")
    val location: GeoRaw?
)
