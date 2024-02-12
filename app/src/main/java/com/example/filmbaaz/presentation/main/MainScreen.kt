package com.example.filmbaaz.presentation.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.filmbaaz.library.designsystem.base.BaseRoute
import com.example.filmbaaz.navigation.Destinations
import com.example.filmbaaz.navigation.FilmBaazNavHost
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    var isLoading by remember { mutableStateOf(true) }
    var isGlitch by remember { mutableStateOf(false) }
    var isRetry by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    BaseRoute(
        isLoading,
        isGlitch,
        onRetry = {
            isRetry = true
            scope.launch {
                delay(1000)
                isRetry = false
            }
        }
    ) {
        FilmBaazNavHost(
            navController = navController,
            startDestination = Destinations.UpcomingMoviesScreen.route,
            modifier = Modifier,
            onLoading = {
                isLoading = it
            },
            onGlitch = {
                isGlitch = it
            },
            isRetry
        )
    }


}
