package dev.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.brunofelix.pmovie.feature.movie.domain.model.Dates

data class DatesDto(
    @SerializedName("maximum")
    val maximum: String?,

    @SerializedName("minimum")
    val minimum: String?
) {
    fun toDates(): Dates {
        return Dates(
            maximum = maximum ?: "",
            minimum = minimum ?: ""
        )
    }
}