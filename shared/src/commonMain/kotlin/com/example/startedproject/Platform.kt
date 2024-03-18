package com.example.startedproject

expect class Platform {
    val oSName: String
    val oSVersion: String
    val deviceModel: String
    val density: Int

    fun logSystemInfo()
}