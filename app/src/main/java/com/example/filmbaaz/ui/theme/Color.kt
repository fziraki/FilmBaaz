package com.example.filmbaaz.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val gray_CBC8C8 = Color(0xFFCBC8C8)
private val white = Color(0xFFFFFFFF)
private val black = Color(0xFF000000)
private val green_4BC381 = Color(0xFF4BC381)
private val red_FF3D00 = Color(0xFFFF3D00)
private val red_EB5757 = Color(0xFFEB5757)
private val gray_44464E = Color(0xFF44464E)
private val black_191A1F = Color(0xFF191A1F)
private val blue_1C3051 = Color(0xFF1C3051)
private val blue_7E91B7 = Color(0xFF7E91B7)

interface ColorVariant {
    val light: Color
    val dark: Color
}

enum class DefaultColorsVariant : ColorVariant {

    Background {
        override val light: Color = white
        override val dark: Color = black
    },

    OnSurface {
        override val light: Color = black
        override val dark: Color = white
    },

    OnSurfaceVariant {
        override val light: Color = blue_7E91B7
        override val dark: Color = blue_7E91B7
    },

    OnSurfaceFixed {
        override val light: Color = white
        override val dark: Color = white
    },


    MovieTitle {
        override val light: Color = black
        override val dark: Color = gray_CBC8C8
    },

    Green {
        override val light: Color = green_4BC381
        override val dark: Color = green_4BC381
    },

    Red {
        override val light: Color = red_FF3D00
        override val dark: Color = red_FF3D00
    },

    RedAction {
        override val light: Color = red_EB5757
        override val dark: Color = red_EB5757
    },

    ButtonBorder{
        override val light: Color = gray_44464E
        override val dark: Color = gray_44464E
    },

    ButtonBackground {
        override val light: Color = black_191A1F
        override val dark: Color = black_191A1F
    },

    RetryButtonBackground {
        override val light: Color = blue_1C3051
        override val dark: Color = blue_1C3051
    }

}

@Immutable
data class Colors(
    val background: Color,
    val movieTitle: Color,
    val green: Color,
    val red: Color,
    val redAction: Color,
    val buttonBorder: Color,
    val buttonBackground: Color,
    val retryButtonBackground: Color,
    val onSurface: Color,
    val onSurfaceVariant: Color,
    val onSurfaceFixed: Color,
    val isLight: Boolean
)

object DefaultColors {
    val lightColors: Colors = Colors(
        background = DefaultColorsVariant.Background.light,
        movieTitle = DefaultColorsVariant.MovieTitle.light,
        green = DefaultColorsVariant.Green.light,
        red = DefaultColorsVariant.Red.light,
        redAction = DefaultColorsVariant.RedAction.light,
        buttonBorder = DefaultColorsVariant.ButtonBorder.light,
        buttonBackground = DefaultColorsVariant.ButtonBackground.light,
        retryButtonBackground = DefaultColorsVariant.RetryButtonBackground.light,
        onSurface = DefaultColorsVariant.OnSurface.light,
        onSurfaceVariant = DefaultColorsVariant.OnSurfaceVariant.light,
        onSurfaceFixed = DefaultColorsVariant.OnSurfaceFixed.light,
        isLight = true
    )

    val darkColors: Colors = Colors(
        background = DefaultColorsVariant.Background.dark,
        movieTitle = DefaultColorsVariant.MovieTitle.dark,
        green = DefaultColorsVariant.Green.dark,
        red = DefaultColorsVariant.Red.dark,
        redAction = DefaultColorsVariant.RedAction.dark,
        buttonBorder = DefaultColorsVariant.ButtonBorder.dark,
        buttonBackground = DefaultColorsVariant.ButtonBackground.dark,
        retryButtonBackground = DefaultColorsVariant.RetryButtonBackground.dark,
        onSurface = DefaultColorsVariant.OnSurface.dark,
        onSurfaceVariant = DefaultColorsVariant.OnSurfaceVariant.dark,
        onSurfaceFixed = DefaultColorsVariant.OnSurfaceFixed.dark,
        isLight = false
    )
}


val LocalColor = staticCompositionLocalOf {
    DefaultColors.lightColors
}