package com.example.startedproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform