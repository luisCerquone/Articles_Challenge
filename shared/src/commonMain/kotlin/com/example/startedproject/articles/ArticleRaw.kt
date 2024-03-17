package com.example.startedproject.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val desc: String?,
    @SerialName("author")
    val author: String?,
    @SerialName("content")
    val content: String?,
    @SerialName("publishedAt")
    val date: String,
    @SerialName("urlToImage")
    val imageUrl: String?
)