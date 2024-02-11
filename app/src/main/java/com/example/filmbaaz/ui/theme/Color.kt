package com.example.filmbaaz.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val primary_14171E = Color(0xFF14171E)
private val primary_282E3D = Color(0xFF282E3D)
private val primary_000000 = Color(0xFF000000)

private val secondary_F95738 = Color(0xFFF95738)
private val secondary_F97238 = Color(0xFFF97238)
private val secondary_EF4C2C = Color(0xFFEF4C2C)

private val error_F2194A = Color(0xFFF2194A)
private val error_FDDCE3 = Color(0xFFFDDCE3)
private val error_DA0C3A = Color(0xFFDA0C3A)


interface ColorVariant {
    val light: Color
    val dark: Color
}

enum class DefaultColorsVariant : ColorVariant {

    ErrorDA0C3A {
        override val light: Color = error_DA0C3A
        override val dark: Color = error_DA0C3A
    },
    ErrorFDDCE3 {
        override val light: Color = error_FDDCE3
        override val dark: Color = error_FDDCE3
    },
    ErrorF2194A {
        override val light: Color = error_F2194A
        override val dark: Color = error_F2194A
    },
    SecondaryEF4C2C {
        override val light: Color = secondary_EF4C2C
        override val dark: Color = secondary_EF4C2C
    },
    SecondaryF97238 {
        override val light: Color = secondary_F97238
        override val dark: Color = secondary_F97238
    },
    SecondaryF95738 {
        override val light: Color = secondary_F95738
        override val dark: Color = secondary_F95738
    },
    Primary000000 {
        override val light: Color = primary_000000
        override val dark: Color = primary_000000
    },
    Primary282E3D {
        override val light: Color = primary_282E3D
        override val dark: Color = primary_282E3D
    },
    Primary14171E {
        override val light: Color = primary_14171E
        override val dark: Color = primary_14171E
    },

}

@Immutable
data class Colors(
    val primary_14171E: Color,
    val primary_282E3D: Color,
    val primary_000000: Color,
    val secondary_F95738: Color,
    val secondary_F97238: Color,
    val secondary_EF4C2C: Color,
    val error_F2194A: Color,
    val error_FDDCE3: Color,
    val error_DA0C3A: Color,
    val isLight: Boolean
)

object DefaultColors {
    val lightColors: Colors = Colors(
        primary_14171E = DefaultColorsVariant.Primary14171E.light,
        primary_282E3D = DefaultColorsVariant.Primary282E3D.light,
        primary_000000 = DefaultColorsVariant.Primary000000.light,
        secondary_F95738 = DefaultColorsVariant.SecondaryF95738.light,
        secondary_F97238 = DefaultColorsVariant.SecondaryF97238.light,
        secondary_EF4C2C = DefaultColorsVariant.SecondaryEF4C2C.light,
        error_F2194A = DefaultColorsVariant.ErrorF2194A.light,
        error_FDDCE3 = DefaultColorsVariant.ErrorFDDCE3.light,
        error_DA0C3A = DefaultColorsVariant.ErrorDA0C3A.light,
        isLight = true
    )

    val darkColors: Colors = Colors(
        primary_14171E = DefaultColorsVariant.Primary14171E.dark,
        primary_282E3D = DefaultColorsVariant.Primary282E3D.dark,
        primary_000000 = DefaultColorsVariant.Primary000000.dark,
        secondary_F95738 = DefaultColorsVariant.SecondaryF95738.dark,
        secondary_F97238 = DefaultColorsVariant.SecondaryF97238.dark,
        secondary_EF4C2C = DefaultColorsVariant.SecondaryEF4C2C.dark,
        error_F2194A = DefaultColorsVariant.ErrorF2194A.dark,
        error_FDDCE3 = DefaultColorsVariant.ErrorFDDCE3.dark,
        error_DA0C3A = DefaultColorsVariant.ErrorDA0C3A.dark,
        isLight = false
    )
}


val LocalColor = staticCompositionLocalOf {
    DefaultColors.lightColors
}