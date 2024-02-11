package com.example.filmbaaz.utils

sealed class ErrorEntity {

    object NoConnection : ErrorEntity()

    object ServiceUnavailable : ErrorEntity()

    //invalidID, invalid comment or postID
    object BadRequest: ErrorEntity()

    object HTTP_401: ErrorEntity()

    //expired token, invalid refresh token
    object Forbidden: ErrorEntity()

    //not found
    object NotFound: ErrorEntity()

    //expired token
    object HTTP_406: ErrorEntity()

    //duplicate bookmark, category already exists
    object Conflict: ErrorEntity()

    //duplicate phone number in 2 minutes
    object HTTP_422: ErrorEntity()

    //duplicate phone number in 2 minutes
    object HTTP_425: ErrorEntity()


    object Unknown : ErrorEntity()
}