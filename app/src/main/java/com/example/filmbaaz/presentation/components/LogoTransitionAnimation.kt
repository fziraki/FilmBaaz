package com.example.filmbaaz.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.filmbaaz.R

@Composable
fun LogoTransitionAnimation(
    visible: Boolean,
    animationFinished: () -> Unit
){

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.toFloat()
    val screenHeight = configuration.screenHeightDp.toFloat()
    val screenWidthInDp = configuration.screenWidthDp

    val animationTime = 2000
    val animationDelayTime = 5

    val arrowStartLocation = Offset(screenWidth.div(2), screenHeight.div(2))
    val arrowEndLocation = Offset((screenWidthInDp-38-16).toFloat(), (8.dp).value)

    val arrowLocation by animateOffsetAsState(
        targetValue = if (visible) arrowEndLocation else arrowStartLocation,
        animationSpec = tween(animationTime, animationDelayTime),
        finishedListener = {
            animationFinished()
        }, label = ""
    )

    val width by animateDpAsState(if (visible) 38.dp else 79.dp)
    val height by animateDpAsState(if (visible) 41.dp else 88.dp)

        Image(
            painterResource(R.drawable.logo),
            contentDescription = "Bazaar Logo",
            modifier = Modifier
                .size(width, height)
                .offset(arrowLocation.x.dp, arrowLocation.y.dp)
        )



}