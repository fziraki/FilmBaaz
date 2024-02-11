package com.example.filmbaaz.presentation.upcomingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import com.example.filmbaaz.data.repository.UpcomingMoviesSource
import com.example.filmbaaz.domain.model.Movie
import com.example.filmbaaz.domain.use_case.GetUpcomingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UpcomingMoviesViewModel @Inject constructor(
    getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
): ViewModel(){

    private lateinit var pagingSource: PagingSource<Int, Movie>

    val upcomingMoviesPagingFlow: Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(
            pageSize = UpcomingMoviesSource.PAGE_SIZE,
            prefetchDistance = UpcomingMoviesSource.PREFETCH_DISTANCE
        ),
        pagingSourceFactory = {
            pagingSource = getUpcomingMoviesUseCase()
            pagingSource
        }
    ).flow
        .cachedIn(viewModelScope)


}
