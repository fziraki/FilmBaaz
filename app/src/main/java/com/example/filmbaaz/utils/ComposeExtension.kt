package com.example.filmbaaz.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import coil.compose.SubcomposeAsyncImage
import coil.imageLoader
import coil.request.ImageRequest
import com.example.filmbaaz.presentation.components.shimmerEffectBrush
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun LoadImage(
    modifier: Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(5.dp),
    url: String,
    errorImage: String,
    contentScale: ContentScale = ContentScale.Crop,
    hasShimmer: Boolean = true
){

    val context = LocalContext.current

    val showShimmer = remember { mutableStateOf(false) }
    val imageUrl = remember { mutableStateOf(url) }

    val imageRequest = ImageRequest.Builder(context)
        .data(imageUrl.value)
        .memoryCacheKey(imageUrl.value)
        .diskCacheKey(imageUrl.value)
        .build()

    SubcomposeAsyncImage(
        modifier = modifier
            .fillMaxSize()
            .then(
                if (showShimmer.value) {
                    modifier.background(brush = shimmerEffectBrush(), shape = shape)
                } else {
                    modifier.padding()
                }
            ),
        model = imageRequest,
        contentDescription = "image",
        onLoading = {
            if (hasShimmer){
                showShimmer.value = true
            }
        },
        onSuccess = {
            if (hasShimmer){
                showShimmer.value = false
            }
        },
        onError = {
            if (hasShimmer){
                showShimmer.value = false
            }
        },
        error = { imageUrl.value = errorImage },
        contentScale = contentScale,
        imageLoader = context.imageLoader,
    )
}


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun <T> StateFlow<T>.collectAsLifecycleAwareState(
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): State<T> {
    return rememberFlowWithLifecycle(
        flow = this,
        lifecycle = lifecycle,
        minActiveState = minActiveState
    ).collectAsState(initial = value)
}

@Composable
fun <T> rememberFlowWithLifecycle(
    flow: Flow<T>,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): Flow<T> = remember(flow, lifecycle) {
    flow.flowWithLifecycle(
        lifecycle = lifecycle,
        minActiveState = minActiveState
    )
}