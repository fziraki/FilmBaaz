package com.example.filmbaaz.presentation.upcomingList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.filmbaaz.presentation.components.LoadingBar
import com.example.filmbaaz.presentation.components.UpcomingMovieItem
import com.example.filmbaaz.ui.theme.FilmBaazTheme

@Composable
fun UpcomingMoviesScreen(
    onBackPressed: () -> Unit,
    viewModel: UpcomingMoviesViewModel = hiltViewModel()
){

    val lazyPagingUpcomingMovies = viewModel.upcomingMoviesPagingFlow.collectAsLazyPagingItems()
    val lazyListState = rememberLazyGridState()

    LazyVerticalGrid(
        modifier = Modifier
            .background(FilmBaazTheme.colors.background)
            .fillMaxSize(),
        state = lazyListState,
        columns = GridCells.Adaptive(minSize = 119.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        content = {
            // InfiniteRecommendedNewsForYou
            if (lazyPagingUpcomingMovies.loadState.refresh == LoadState.Loading) {
                item {
                    LoadingBar()
                }
            }

            items(
                count = lazyPagingUpcomingMovies.itemCount,
                key = lazyPagingUpcomingMovies.itemKey{ it.id },
                span = { GridItemSpan(1) }
            ) { index ->
                val movie = lazyPagingUpcomingMovies[index]
                movie?.let {
                    UpcomingMovieItem(
                        movie = it,
                        onMovieItemClick = {

                        }
                    )
                }
            }

            if (lazyPagingUpcomingMovies.loadState.append == LoadState.Loading) {
                item {
                    LoadingBar()
                }
            }
        },
    )

}