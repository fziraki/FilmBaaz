package com.example.filmbaaz.data.remote

import com.example.filmbaaz.data.dto.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApi {

    companion object{
        const val INITIAL_PAGE = 1
        const val GENERAL_PAGE_SIZE = 10
    }

    @Headers("isAuthorizable: true")
    @GET("3/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int = INITIAL_PAGE,
        @Query("size") size: Int = GENERAL_PAGE_SIZE
    ): MovieListDto
}