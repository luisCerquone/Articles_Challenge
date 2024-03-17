package com.example.startedproject.articles

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val repository: ArticlesRepository) {

    companion object {
        const val DEFAULT_DESCRIPTION = "Click to find out more"
        const val DEFAULT_CONTENT = "Click to find out more content"
        const val DEFAULT_AUTHOR = "Unknown"
        const val DEFAULT_IMAGE_URL =
            "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
    }

    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articlesRaw = repository.getArticles(forceFetch)
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map { raw ->
        Article(
            raw.title,
            raw.desc ?: DEFAULT_DESCRIPTION,
            raw.author ?: DEFAULT_AUTHOR,
            raw.content ?: DEFAULT_CONTENT,
            getDaysAgoString(raw.date),
            raw.imageUrl ?: DEFAULT_IMAGE_URL
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}