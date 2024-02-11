package com.example.filmbaaz.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.filmbaaz.R
import com.example.filmbaaz.library.designsystem.base.BaseRoute
import com.example.filmbaaz.navigation.Destinations
import com.example.filmbaaz.navigation.NetroNavHost
import com.example.filmbaaz.presentation.components.CustomSnackbar

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState){ data ->
            CustomSnackbar(
                message = data.visuals.message
            )
        } },
        topBar = {
            MainTopBar()

        },
    ) { paddingValues ->
        BaseRoute{
            NetroNavHost(
                navController = navController,
                startDestination = Destinations.UpcomingMoviesScreen.route,
                modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
            )
        }
    }

}


@Composable
fun MainTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Bazaar logo",
            modifier = Modifier.width(50.dp)
        )


    }
}