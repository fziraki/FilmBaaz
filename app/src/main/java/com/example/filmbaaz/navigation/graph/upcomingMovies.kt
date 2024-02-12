package com.example.filmbaaz.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.filmbaaz.navigation.Destinations
import com.example.filmbaaz.presentation.upcomingList.UpcomingMoviesScreen

fun NavGraphBuilder.upcomingMovies(
    navController: NavController,
    onLoading: (Boolean) -> Unit,
    onGlitch: (Boolean) -> Unit,
    isRetry: Boolean,
) {
    composable(
        route = Destinations.UpcomingMoviesScreen.route
    ) {
        UpcomingMoviesScreen(
            onBackPressed = {
                navController.navigateUp()
            },
            onLoading = onLoading,
            onGlitch = onGlitch,
            isRetry = isRetry
        )
    }
}