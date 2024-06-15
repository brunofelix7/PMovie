package me.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import me.brunofelix.pmovie.core.domain.model.Dates

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