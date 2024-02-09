package com.example.filmbaaz.utils

interface ErrorHandler {

    fun getError(throwable: Throwable): ErrorEntity
}