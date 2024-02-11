package com.example.filmbaaz.di

import com.example.filmbaaz.data.remote.MoviesApi
import com.example.filmbaaz.data.repository.MoviesRepositoryImpl
import com.example.filmbaaz.domain.repository.MoviesRepository
import com.example.filmbaaz.domain.use_case.GetUpcomingMoviesUseCase
import com.example.filmbaaz.utils.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object MoviesModule {

    @Provides
    @ViewModelScoped
    fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideMoviesRepository(
        moviesApi: MoviesApi,
        errorHandler: ErrorHandler
    ): MoviesRepository {
        return MoviesRepositoryImpl(
            moviesApi = moviesApi,
            errorHandler = errorHandler
        )
    }

    @Provides
    @ViewModelScoped
    fun provideGetUpcomingMoviesUseCase(moviesRepository: MoviesRepository): GetUpcomingMoviesUseCase {
        return GetUpcomingMoviesUseCase(moviesRepository)
    }


}