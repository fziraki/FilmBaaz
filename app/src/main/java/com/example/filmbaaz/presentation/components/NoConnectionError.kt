package com.example.filmbaaz.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.filmbaaz.R
import com.example.filmbaaz.ui.theme.FilmBaazTheme

@Composable
fun NoConnectionError(
    onRetry: () -> Unit
){

    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(FilmBaazTheme.colors.background),
        contentAlignment = Alignment.Center
    ){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(FilmBaazTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painterResource(R.drawable.ic_sad_face),
                contentDescription = "No connection",
                modifier = Modifier.size(96.dp)
            )

            Text(
                modifier = Modifier,
                text = stringResource(id = R.string.connection_glitch),
                style = FilmBaazTheme.typography.subtitle3,
                color = FilmBaazTheme.colors.onSurface,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier,
                text = stringResource(id = R.string.connection_glitch_desc),
                style = FilmBaazTheme.typography.subtitle3,
                color = FilmBaazTheme.colors.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Button(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(48.dp),
                onClick = { onRetry() },
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = FilmBaazTheme.colors.retryButtonBackground
                ),
            ) {

                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = stringResource(id = R.string.retry),
                    textAlign = TextAlign.Center,
//                    style = SmartNewsAppTheme.typography.button,
                    color = FilmBaazTheme.colors.onSurfaceFixed
                )
            }

        }
    }



}