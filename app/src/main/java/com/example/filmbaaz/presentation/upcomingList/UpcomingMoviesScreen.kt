package com.example.filmbaaz.presentation.upcomingList

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.LoadState.Loading.endOfPaginationReached
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.filmbaaz.R
import com.example.filmbaaz.domain.model.Movie
import com.example.filmbaaz.presentation.components.CustomSnackbar
import com.example.filmbaaz.presentation.components.LoadingBar
import com.example.filmbaaz.presentation.components.UpcomingMovieItem
import com.example.filmbaaz.ui.theme.FilmBaazTheme
import com.example.filmbaaz.utils.UiText
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

@Composable
fun UpcomingMoviesScreen(
    onBackPressed: () -> Unit,
    onLoading: (Boolean) -> Unit,
    onGlitch: (Boolean) -> Unit,
    isRetry: Boolean,
    title: (String) -> Unit,
    viewModel: UpcomingMoviesViewModel = hiltViewModel()
){

    val lazyPagingUpcomingMovies = viewModel.upcomingMoviesPagingFlow.collectAsLazyPagingItems()
    val message = viewModel.snackBarMessage
    val glitch = viewModel.glitchError
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        title(UiText.StringResource(R.string.discover).asString(context))
        glitch.collect {
            onGlitch(it)
        }
    }
    val retry by remember { mutableStateOf(isRetry) }

    if (retry){
        viewModel.invalidateSource()
    }

    UpComingMoviesComponent(
        message,
        lazyPagingUpcomingMovies,
        onLoading = {
            onLoading(it)
        },
        onError = {
            viewModel.translateError(it)
        },
        onTryAgain = {
            viewModel.invalidateSource()
        }
    )


}


@Composable
fun UpComingMoviesComponent(
    message: SharedFlow<UiText>,
    lazyPagingUpcomingMovies: LazyPagingItems<Movie>,
    onLoading: (Boolean) -> Unit,
    onError: (Throwable) -> Unit,
    onTryAgain: () -> Unit,
) {

    val lazyListState = rememberLazyGridState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        message.collect {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(
                    message = it.asString(context)
                )
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState){ data ->
            CustomSnackbar(
                message = data.visuals.message,
                onTryAgain = onTryAgain
            )
        } },
        bottomBar = {
            Box(modifier = Modifier
                .background(FilmBaazTheme.colors.background)
                .fillMaxWidth()
                .padding(vertical = 16.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                AnimatedVisibility(
                    visible = lazyPagingUpcomingMovies.loadState.append == LoadState.Loading,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    LoadingBar(modifier = Modifier.fillMaxWidth())
                }
            }
        },
        containerColor = FilmBaazTheme.colors.background
    ) { paddingValues ->

        LazyVerticalGrid(
            modifier = Modifier
                .background(FilmBaazTheme.colors.background)
                .fillMaxSize(),
            state = lazyListState,
            columns = GridCells.Adaptive(minSize = 119.dp),
            contentPadding = PaddingValues(
                top = paddingValues.calculateTopPadding()+24.dp,
                start = 8.dp, end = 8.dp,
                bottom = paddingValues.calculateBottomPadding()+64.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            content = {

                if (lazyPagingUpcomingMovies.loadState.source.append is LoadState.Error) {
                    onError((lazyPagingUpcomingMovies.loadState.source.append as LoadState.Error).error)
                }

                if (lazyPagingUpcomingMovies.loadState.source.refresh is LoadState.Error) {
                    onError((lazyPagingUpcomingMovies.loadState.source.refresh as LoadState.Error).error)
                }

                if(lazyPagingUpcomingMovies.loadState.source.refresh is LoadState.Loading &&
                    !endOfPaginationReached){
                    onLoading(true)
                }

                if(lazyPagingUpcomingMovies.loadState.source.refresh is LoadState.NotLoading &&
                    !endOfPaginationReached){
                    onLoading(false)
                    items(
                        count = lazyPagingUpcomingMovies.itemCount,
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
                }
            },
        )
    }

}


@Composable
fun Header() {

    Box(modifier = Modifier
        .background(FilmBaazTheme.colors.background)
        .fillMaxWidth()
        .height(56.dp)
        .padding(horizontal = 8.dp),
        contentAlignment = Alignment.CenterEnd
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.discover),
//            style = SmartNewsAppTheme.typography.title5,
            color = FilmBaazTheme.colors.red,
            textAlign = TextAlign.Center,
            minLines = 1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }







}
