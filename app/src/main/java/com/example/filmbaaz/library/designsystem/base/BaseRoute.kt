package com.example.filmbaaz.library.designsystem.base

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.filmbaaz.presentation.components.LoadingBar
import com.example.filmbaaz.ui.theme.FilmBaazTheme

@Composable
fun BaseRoute(
    isLoading: Boolean,
    content: @Composable () -> Unit,
) {
    BaseScreen(
        isLoading = isLoading,
        content = content
    )
}

@Composable
private fun BaseScreen(
    isLoading: Boolean,
    content: @Composable () -> Unit,
) {


    Box(modifier = Modifier
        .fillMaxSize()
        .background(FilmBaazTheme.colors.background),
        contentAlignment = Alignment.Center
    ){
        content()
        AnimatedVisibility(
            visible = isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LoadingBar(modifier = Modifier
                .fillMaxSize()
                .background(FilmBaazTheme.colors.background))
        }
    }


}


