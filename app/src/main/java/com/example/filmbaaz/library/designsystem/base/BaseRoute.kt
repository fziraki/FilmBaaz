package com.example.filmbaaz.library.designsystem.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BaseRoute(
    content: @Composable () -> Unit,
) {
    BaseScreen(
        content = content
    )
}

@Composable
private fun BaseScreen(
    content: @Composable () -> Unit,
) {

    Box(modifier = Modifier
        .padding(top = 80.dp)
        .fillMaxSize()
        .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ){
        content()
    }


}


