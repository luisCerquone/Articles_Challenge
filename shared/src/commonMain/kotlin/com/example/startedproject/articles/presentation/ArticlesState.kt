package com.example.startedproject.articles.presentation

import com.example.startedproject.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)