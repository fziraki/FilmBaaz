package com.example.filmbaaz.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.filmbaaz.base.BaseState
import com.example.filmbaaz.navigation.graph.upcomingMovies

@Composable
fun FilmBaazNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier,
    title: (String) -> Unit,
    onState: (BaseState) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
    ) {

        upcomingMovies(navController, title, onState)

    }
}