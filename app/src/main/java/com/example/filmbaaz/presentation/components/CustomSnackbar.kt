package com.example.filmbaaz.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.filmbaaz.ui.theme.FilmBaazTheme

@Composable
fun CustomSnackbar(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp),
    message: String,
    containerColor: Color = FilmBaazTheme.colors.background
) {

    Snackbar(
        modifier = modifier
            .height(56.dp),
        containerColor = containerColor,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = message,
                style = FilmBaazTheme.typography.subtitle3,
                color = FilmBaazTheme.colors.movieTitle
            )
        }
    }
}

