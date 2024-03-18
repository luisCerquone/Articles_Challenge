package com.example.startedproject.users.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoRaw(
    @SerialName("lat")
    val lat: String?,
    @SerialName("lng")
    val lng: String?
)
