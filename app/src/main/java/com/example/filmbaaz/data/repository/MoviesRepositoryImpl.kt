package com.example.filmbaaz.data.repository

import androidx.paging.PagingSource
import com.example.filmbaaz.data.remote.MoviesApi
import com.example.filmbaaz.domain.model.Movie
import com.example.filmbaaz.domain.repository.MoviesRepository
import com.example.filmbaaz.utils.ErrorHandler
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi,
    private val errorHandler: ErrorHandler
): MoviesRepository {

    override fun getUpcomingMovies(): PagingSource<Int, Movie> {
        return UpcomingMoviesSource(
            moviesApi = moviesApi
        )
    }


}