package com.example.startedproject.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.startedproject.android.screens.AboutScreen
import com.example.startedproject.android.screens.ArticleScreen
import com.example.startedproject.android.screens.ArticlesScreen
import com.example.startedproject.android.screens.Screens
import com.example.startedproject.android.screens.UserScreen
import com.example.startedproject.articles.presentation.ArticlesViewModel
import com.example.startedproject.users.presentation.UserViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val articlesViewModel: ArticlesViewModel = getViewModel()
    val userViewModel: UserViewModel = getViewModel()

    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier,
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                articlesViewModel,
                onAboutButtonClick = { navController.navigate(Screens.USERS.route) },
                onArticle = { navController.navigate(Screens.ARTICLE.route) }
            )
        }

        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }

        composable(Screens.ARTICLE.route) {
            ArticleScreen(
                articlesViewModel,
                onUpButtonClick = { navController.popBackStack() }
            )
        }

        composable(Screens.USERS.route) {
            UserScreen(
                userViewModel,
                onUpButtonClick = { navController.popBackStack() },
                onUser = { navController.navigate(Screens.USER.route) }
            )
        }

        composable(Screens.USER.route) {

        }
    }
}