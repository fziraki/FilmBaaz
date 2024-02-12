package com.example.filmbaaz.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.filmbaaz.R
import com.example.filmbaaz.ui.theme.FilmBaazTheme

@Composable
fun CustomSnackbar(
    modifier: Modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
    message: String,
    containerColor: Color = FilmBaazTheme.colors.background,
    onTryAgain: () -> Unit
) {

    Snackbar(
        modifier = modifier,
        containerColor = containerColor,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier,
                text = message,
                style = FilmBaazTheme.typography.subtitle3,
                color = FilmBaazTheme.colors.movieTitle
            )

            OutlinedButton(
                modifier = Modifier.wrapContentHeight().height(36.dp),
                onClick = { onTryAgain() },
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, FilmBaazTheme.colors.buttonBorder),
                colors = ButtonDefaults.buttonColors(
                    containerColor = FilmBaazTheme.colors.buttonBackground
                ),
            ) {

                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = stringResource(id = R.string.try_again),
                    textAlign = TextAlign.Center,
//                    style = SmartNewsAppTheme.typography.button,
                    color = FilmBaazTheme.colors.redAction
                )
            }

        }
    }
}

