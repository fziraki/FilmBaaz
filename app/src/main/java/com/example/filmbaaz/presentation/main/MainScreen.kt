package com.example.filmbaaz.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.filmbaaz.base.BaseState
import com.example.filmbaaz.library.designsystem.base.BaseRoute
import com.example.filmbaaz.navigation.Destinations
import com.example.filmbaaz.navigation.FilmBaazNavHost
import com.example.filmbaaz.presentation.components.LoadingBar
import com.example.filmbaaz.presentation.components.LogoTransitionAnimation
import com.example.filmbaaz.presentation.components.NoConnectionError
import com.example.filmbaaz.ui.theme.FilmBaazTheme

@Composable
fun MainScreen(
) {

    var state by remember { mutableStateOf<BaseState>(BaseState.OnSuccess) }

    val navController = rememberNavController()

    var visible by remember { mutableStateOf(false) }
    var isAnimationFinished by remember { mutableStateOf(false) }
    var screenTitle by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        visible = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FilmBaazTheme.colors.background)
    ){
        LogoTransitionAnimation(
            visible,
            animationFinished = {
                isAnimationFinished = true
            }
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            text = screenTitle,
            color = FilmBaazTheme.colors.red,
            textAlign = TextAlign.Center,
            minLines = 1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )


        if (isAnimationFinished){

            BaseRoute {
                FilmBaazNavHost(
                    navController = navController,
                    startDestination = Destinations.UpcomingMoviesScreen.route,
                    modifier = Modifier,
                    title = {
                        screenTitle = it
                    },
                    onState = {
                        state = it
                    }
                )
            }

            when(state){
                BaseState.OnLoading -> {
                    LoadingBar(
                        Modifier
                            .padding(top = 80.dp)
                            .fillMaxSize()
                            .background(FilmBaazTheme.colors.background))
                }
                is BaseState.OnError -> {
                    NoConnectionError(
                        onRetry = {
                            navController.navigate(
                                route = Destinations.UpcomingMoviesScreen.route,
                            )
                        }
                    )
                }
                BaseState.OnSuccess -> {
                }
            }
        }



    }




}
