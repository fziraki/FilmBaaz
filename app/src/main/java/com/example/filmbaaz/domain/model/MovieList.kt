package com.example.filmbaaz.domain.model


import androidx.compose.runtime.Immutable

@Immutable
data class MovieList(
    val dates: Dates,
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)