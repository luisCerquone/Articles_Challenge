package com.example.startedproject.android.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.startedproject.articles.domain.Article
import com.example.startedproject.articles.presentation.ArticlesViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState

@Composable
fun ArticlesScreen(
    articlesViewModel: ArticlesViewModel,
    onAboutButtonClick: () -> Unit,
    onArticle: () -> Unit
) {
    val articlesState = articlesViewModel.articlesState.collectAsState()

    Column {
        AppBar(onAboutButtonClick)

        if (articlesState.value.error != null)
            ErrorMessage(articlesState.value.error!!)
        if (articlesState.value.articles.isNotEmpty())
            ArticlesListView(articlesViewModel, onArticle)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    onAboutButtonClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
            IconButton(onClick = onAboutButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "About Device Button",
                )
            }
        }
    )
}

@Composable
fun ArticlesListView(viewModel: ArticlesViewModel, onArticle: () -> Unit) {

    SwipeRefresh(
        state = SwipeRefreshState(viewModel.articlesState.value.loading),
        onRefresh = { viewModel.getArticles(true) }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.articlesState.value.articles) { article ->
                ArticleItemView(viewModel, article = article, onArticle)
            }
        }
    }
}

@Composable
fun ArticleItemView(viewModel: ArticlesViewModel, article: Article, onArticle: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                viewModel.selectArticle(article)
                onArticle()
            }
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun ErrorMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}