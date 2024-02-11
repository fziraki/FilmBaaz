package com.example.filmbaaz.library.designsystem.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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

    Box(modifier = Modifier.fillMaxSize()){
        content()
    }
}