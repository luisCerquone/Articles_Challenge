package com.example.startedproject.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    companion object {
        private const val country = "us"
        private const val category = "business"
        private const val apiKey = "ef00ffdaa05d49b787b02fe6eae6c8bc"
        const val URL =
            "https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey"
    }

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse =
            httpClient.get(URL)
                .body()
        return response.articles
    }
}