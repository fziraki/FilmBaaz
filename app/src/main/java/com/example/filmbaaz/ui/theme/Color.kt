package com.example.filmbaaz.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val gray_CBC8C8 = Color(0xFFCBC8C8)
private val white = Color(0xFFFFFFFF)
private val black = Color(0xFF000000)

interface ColorVariant {
    val light: Color
    val dark: Color
}

enum class DefaultColorsVariant : ColorVariant {

    Background {
        override val light: Color = white
        override val dark: Color = black
    },

    MovieTitle {
        override val light: Color = black
        override val dark: Color = gray_CBC8C8
    }

}

@Immutable
data class Colors(
    val background: Color,
    val movieTitle: Color,
    val isLight: Boolean
)

object DefaultColors {
    val lightColors: Colors = Colors(
        background = DefaultColorsVariant.Background.light,
        movieTitle = DefaultColorsVariant.MovieTitle.light,
        isLight = true
    )

    val darkColors: Colors = Colors(
        background = DefaultColorsVariant.Background.dark,
        movieTitle = DefaultColorsVariant.MovieTitle.light,
        isLight = false
    )
}


val LocalColor = staticCompositionLocalOf {
    DefaultColors.lightColors
}