package com.example.filmbaaz.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.filmbaaz.library.designsystem.base.BaseRoute
import com.example.filmbaaz.navigation.Destinations
import com.example.filmbaaz.navigation.FilmBaazNavHost

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    var isLoading by remember { mutableStateOf(true) }

    BaseRoute(isLoading) {
        FilmBaazNavHost(
            navController = navController,
            startDestination = Destinations.UpcomingMoviesScreen.route,
            modifier = Modifier,
            onLoading = {
                isLoading = it
            }
        )
    }


}
