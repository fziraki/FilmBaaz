package com.example.filmbaaz.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.filmbaaz.R

object DefaultFontFamily {
    val regular = FontFamily(Font(R.font.iransans_fanum_regular, FontWeight.Normal))
    val medium = FontFamily(Font(R.font.iransans_fanum_medium, FontWeight.Medium))
    val bold = FontFamily(Font(R.font.iransans_fanum_bold, FontWeight.Bold))
}

@Immutable
data class Typography(
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title4: TextStyle,
    val title5: TextStyle,
    val title6: TextStyle,
    val subtitle1: TextStyle,
    val subtitle2: TextStyle,
    val subtitle3: TextStyle,
    val subtitle4: TextStyle,
    val button: TextStyle,
)


object DefaultTypography {

    val typography: Typography = Typography(
        title1 = TextStyle(
            fontFamily = DefaultFontFamily.medium,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            letterSpacing = 0.sp
        ),
        title2 = TextStyle(
            fontFamily = DefaultFontFamily.medium,
            fontSize = 18.sp,
            lineHeight = 27.sp,
            letterSpacing = 0.sp
        ),

        title3 = TextStyle(
            fontFamily = DefaultFontFamily.medium,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp
        ),

        title4 = TextStyle(
            fontFamily = DefaultFontFamily.medium,
            fontSize = 14.sp,
            lineHeight = 21.sp,
            letterSpacing = 0.sp
        ),
        title5 = TextStyle(
            fontFamily = DefaultFontFamily.medium,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp
        ),
        title6 = TextStyle(
            fontFamily = DefaultFontFamily.medium,
            fontSize = 10.sp,
            lineHeight = 15.sp,
            letterSpacing = 0.sp
        ),
        subtitle1 = TextStyle(
            fontFamily = DefaultFontFamily.regular,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp
        ),
        subtitle2 = TextStyle(
            fontFamily = DefaultFontFamily.regular,
            fontSize = 14.sp,
            lineHeight = 21.sp,
            letterSpacing = 0.sp
        ),
        subtitle3 = TextStyle(
            fontFamily = DefaultFontFamily.regular,
            fontSize = 12.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.sp
        ),
        subtitle4 = TextStyle(
            fontFamily = DefaultFontFamily.regular,
            fontSize = 10.sp,
            lineHeight = 15.sp,
            letterSpacing = 0.sp
        ),
        button = TextStyle(
            fontFamily = DefaultFontFamily.medium,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp
        ),
    )
}

val LocalTypography = staticCompositionLocalOf {
    DefaultTypography.typography
}