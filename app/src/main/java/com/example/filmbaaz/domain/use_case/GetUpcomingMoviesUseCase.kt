package com.example.filmbaaz.domain.use_case

import androidx.paging.PagingSource
import com.example.filmbaaz.domain.model.Movie
import com.example.filmbaaz.domain.repository.MoviesRepository
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(): PagingSource<Int, Movie> {
        return moviesRepository.getUpcomingMovies()
    }
}