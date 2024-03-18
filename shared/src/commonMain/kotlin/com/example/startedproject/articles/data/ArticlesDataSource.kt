package com.example.startedproject.articles.data

import example.startedproject.db.ArticlesAppDatabase

class ArticlesDataSource(private val database: ArticlesAppDatabase) {

    fun getAllArticles(): List<ArticleRaw> =
        database.articlesDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.articlesDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() =
        database.articlesDatabaseQueries.removeAllArticles()

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.articlesDatabaseQueries.insertArticle(
            articleRaw.title,
            articleRaw.desc,
            articleRaw.author,
            articleRaw.content,
            articleRaw.date,
            articleRaw.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        author: String?,
        content: String?,
        date: String,
        url: String?
    ): ArticleRaw =
        ArticleRaw(
            title,
            desc,
            author,
            content,
            date,
            url
        )
}