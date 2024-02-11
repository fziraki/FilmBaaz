package com.example.filmbaaz.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.filmbaaz.domain.model.Movie
import com.example.filmbaaz.ui.theme.FilmBaazTheme
import com.example.filmbaaz.utils.LoadImage

@Composable
fun UpcomingMovieItem(
    movie: Movie,
    onMovieItemClick: (Movie) -> Unit,
) {

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
        Card(
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onMovieItemClick(movie)
                }
                .fillMaxWidth()
                .height(154.dp),
            shape = RoundedCornerShape(10.dp),
        ) {
            LoadImage(
                modifier = Modifier.fillMaxSize(),
                url = movie.posterPath,
                errorImage = movie.backdropPath
            )
        }

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = movie.title,
//            style = SmartNewsAppTheme.typography.title5,
            color = FilmBaazTheme.colors.movieTitle,
            textAlign = TextAlign.Center,
            minLines = 1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }



}
