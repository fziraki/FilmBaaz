package com.example.filmbaaz.data.dto


import com.example.filmbaaz.domain.model.MovieList
import com.google.gson.annotations.SerializedName

data class MovieListDto(
    @SerializedName("dates")
    val dates: DatesDto,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
){
    fun toMovieList(): MovieList {
        return MovieList(
            dates = dates.toDates(),
            page = page,
            results = results.map { it.toMovie() },
            totalPages = totalPages,
            totalResults = totalResults
        )
    }
}