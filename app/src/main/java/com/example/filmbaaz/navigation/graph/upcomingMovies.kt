package com.example.filmbaaz.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.filmbaaz.base.BaseState
import com.example.filmbaaz.navigation.Destinations
import com.example.filmbaaz.presentation.upcomingList.UpcomingMoviesScreen

fun NavGraphBuilder.upcomingMovies(
    navController: NavController,
    title: (String) -> Unit,
    onState: (BaseState) -> Unit
) {
    composable(
        route = Destinations.UpcomingMoviesScreen.route
    ) {
        UpcomingMoviesScreen(
            title = title,
            onState = onState
        )
    }
}