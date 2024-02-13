package com.example.filmbaaz.presentation.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.filmbaaz.R
import com.example.filmbaaz.library.designsystem.base.BaseRoute
import com.example.filmbaaz.navigation.Destinations
import com.example.filmbaaz.navigation.FilmBaazNavHost
import com.example.filmbaaz.presentation.components.LogoTransitionAnimation
import com.example.filmbaaz.ui.theme.FilmBaazTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    var isLoading by remember { mutableStateOf(true) }
    var isGlitch by remember { mutableStateOf(false) }
    var isRetry by remember { mutableStateOf(false) }

    var visible by remember { mutableStateOf(false) }
    var isAnimationFinished by remember { mutableStateOf(false) }
    var screenTitle by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        visible = true
    }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FilmBaazTheme.colors.background)
    ){
        LogoTransitionAnimation(
            visible,
            animationFinished = {
                Log.d("tagg","animationFinished")
                isAnimationFinished = true
            }
        )

        Text(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            text = screenTitle,
            color = FilmBaazTheme.colors.red,
            textAlign = TextAlign.Center,
            minLines = 1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )


        if (isAnimationFinished){

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
                    isRetry,
                    title = {
                        screenTitle = it
                    }
                )
            }
        }
    }




}
