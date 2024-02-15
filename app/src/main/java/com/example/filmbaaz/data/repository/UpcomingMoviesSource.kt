package com.example.filmbaaz.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmbaaz.data.remote.MoviesApi
import com.example.filmbaaz.domain.model.Movie
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UpcomingMoviesSource @Inject constructor(
    private val moviesApi: MoviesApi,
): PagingSource<Int, Movie>() {

    companion object {
        const val INITIAL_PAGE = 1
        const val PAGE_SIZE = 9
        const val PREFETCH_DISTANCE = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val page = params.key ?: INITIAL_PAGE
            val upcomingMovies =
                moviesApi.getUpcomingMovies(
                    page = page,
                    size = PAGE_SIZE
                ).toMovieList().results
            LoadResult.Page(
                data = upcomingMovies,
                prevKey = if (page == INITIAL_PAGE) null else page.dec(),
                nextKey = if (upcomingMovies.size < PAGE_SIZE) null else page.inc()
            )
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }
}