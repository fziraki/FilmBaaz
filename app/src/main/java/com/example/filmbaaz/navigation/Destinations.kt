package com.example.filmbaaz.navigation

sealed class Destinations(val route: String) {
    data object UpcomingMoviesScreen : Destinations("upcoming_movies_screen")

}