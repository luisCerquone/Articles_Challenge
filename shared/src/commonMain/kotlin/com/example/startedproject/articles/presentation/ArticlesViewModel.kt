package com.example.startedproject.articles.presentation

import com.example.startedproject.BaseViewModel
import com.example.startedproject.articles.domain.Article
import com.example.startedproject.articles.domain.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    private val _selectedArticle: MutableStateFlow<Article?> = MutableStateFlow(null)
    val selectedArticle: StateFlow<Article?> = _selectedArticle

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.emit(
                ArticlesState(
                    loading = true,
                    articles = _articlesState.value.articles
                )
            )

            val fetchedArticles = useCase.getArticles(forceFetch)

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    fun selectArticle(article: Article) {
        scope.launch {
            _selectedArticle.emit(article)
        }
    }
}