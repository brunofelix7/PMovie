package me.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import me.brunofelix.pmovie.feature.movie.domain.model.Genre

data class GenreDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?
) {
    fun toGenre(): Genre {
        return Genre(
            id = id ?: -1,
            name = name ?: "--"
        )
    }
}