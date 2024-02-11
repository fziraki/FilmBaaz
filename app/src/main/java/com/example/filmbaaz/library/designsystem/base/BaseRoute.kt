package com.example.filmbaaz.library.designsystem.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.filmbaaz.ui.theme.FilmBaazTheme

@Composable
fun BaseRoute(
    content: @Composable () -> Unit,
) {

    BaseScreen(
        content = content,
    )

}

@Composable
private fun BaseScreen(
    content: @Composable () -> Unit,
) {

    Box(modifier = Modifier.fillMaxSize().background(FilmBaazTheme.colors.background)){
        content()
    }
}