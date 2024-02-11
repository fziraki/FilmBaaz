package com.example.filmbaaz.data.dto


import com.example.filmbaaz.domain.model.Dates
import com.google.gson.annotations.SerializedName

data class DatesDto(
    @SerializedName("maximum")
    val maximum: String,
    @SerializedName("minimum")
    val minimum: String
){
    fun toDates(): Dates {
        return Dates(
            maximum = maximum,
            minimum = minimum
        )
    }
}