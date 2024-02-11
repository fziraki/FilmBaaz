package com.example.filmbaaz.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.imageLoader
import coil.request.ImageRequest
import com.example.filmbaaz.presentation.components.shimmerEffectBrush

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