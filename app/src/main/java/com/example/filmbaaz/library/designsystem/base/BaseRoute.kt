package com.example.filmbaaz.library.designsystem.base

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.filmbaaz.presentation.components.LoadingBar
import com.example.filmbaaz.presentation.components.NoConnectionError
import com.example.filmbaaz.ui.theme.FilmBaazTheme

@Composable
fun BaseRoute(
    isLoading: Boolean,
    isGlitching: Boolean,
    onRetry: () -> Unit,
    content: @Composable () -> Unit,
) {
    BaseScreen(
        isLoading = isLoading,
        isGlitching = isGlitching,
        onRetry = onRetry,
        content = content
    )
}

@Composable
private fun BaseScreen(
    isLoading: Boolean,
    isGlitching: Boolean,
    onRetry: () -> Unit,
    content: @Composable () -> Unit,
) {

    Box(modifier = Modifier
        .padding(top = 80.dp)
        .fillMaxSize()
        .background(Color.Transparent),
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

        AnimatedVisibility(
            visible = isGlitching,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            NoConnectionError(
                onRetry = onRetry
            )
        }
    }


}


