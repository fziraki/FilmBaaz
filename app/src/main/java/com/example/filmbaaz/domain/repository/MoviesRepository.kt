package com.example.filmbaaz.domain.repository

import androidx.paging.PagingSource
import com.example.filmbaaz.domain.model.Movie

interface MoviesRepository {
    fun getUpcomingMovies(): PagingSource<Int, Movie>


}