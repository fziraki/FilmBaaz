package com.example.filmbaaz.presentation.upcomingList

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import com.example.filmbaaz.R
import com.example.filmbaaz.base.BaseState
import com.example.filmbaaz.base.BaseViewModel
import com.example.filmbaaz.data.repository.UpcomingMoviesSource
import com.example.filmbaaz.domain.model.Movie
import com.example.filmbaaz.domain.use_case.GetUpcomingMoviesUseCase
import com.example.filmbaaz.utils.ErrorEntity
import com.example.filmbaaz.utils.ErrorHandler
import com.example.filmbaaz.utils.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingMoviesViewModel @Inject constructor(
    getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val errorHandler: ErrorHandler
): BaseViewModel<BaseState>(){

    private val _snackBarMessage = MutableSharedFlow<UiText>()
    val snackBarMessage: SharedFlow<UiText> = _snackBarMessage

    fun onUiEvent(event: BaseState) {
        when(event){

            is BaseState.OnError -> {

                if (errorHandler.getError(event.throwable) == ErrorEntity.NoConnection){
                    sendEventSync(event)
                }else{
                    translateError(event.throwable)
                }
            }
            else -> {
                sendEventSync(event)
            }
        }
    }



    private fun translateError(it: Throwable) {

        val message = when(errorHandler.getError(it)){
            ErrorEntity.BadRequest -> UiText.StringResource(resId = R.string.bad_request)
            ErrorEntity.Forbidden -> UiText.StringResource(resId = R.string.forbidden)
            ErrorEntity.HTTP_401 -> UiText.StringResource(resId = R.string.unauthorized)
            ErrorEntity.NotFound -> UiText.StringResource(resId = R.string.not_found)
            ErrorEntity.ServiceUnavailable -> UiText.StringResource(resId = R.string.service_unavailable)
            ErrorEntity.Unknown -> UiText.StringResource(resId = R.string.unknown)
            else -> {UiText.DynamicString("")}
        }

        viewModelScope.launch {
            _snackBarMessage.emit(message)
        }

    }

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

    fun invalidateSource() {
        pagingSource.invalidate()
    }



}
