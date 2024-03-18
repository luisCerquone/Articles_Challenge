package com.example.startedproject.articles.domain

data class Article(
    val title: String,
    val desc: String,
    val author: String,
    val content: String,
    val date: String,
    val imageUrl: String
)