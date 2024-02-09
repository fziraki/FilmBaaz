package com.example.filmbaaz.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun FilmBaazTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DefaultColors.darkColors else DefaultColors.lightColors

    CompositionLocalProvider(
        LocalTypography provides DefaultTypography.typography,
        LocalColor provides colors,
        content = content
    )
}

object FilmBaazTheme {
    val typography: Typography
        @Composable
        @ReadOnlyComposable get() = LocalTypography.current

    val colors: Colors
        @Composable
        @ReadOnlyComposable get() = LocalColor.current
}