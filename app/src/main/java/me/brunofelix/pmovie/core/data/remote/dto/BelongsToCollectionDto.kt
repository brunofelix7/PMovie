package me.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import me.brunofelix.pmovie.core.domain.model.BelongsToCollection

data class BelongsToCollectionDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("backdrop_path")
    val backdropPath: String?
) {
    fun toBelongsToCollection(): BelongsToCollection {
        return BelongsToCollection(
            id = id ?: -1,
            name = name ?: "--",
            posterPath = posterPath ?: "",
            backdropPath = backdropPath ?: ""
        )
    }
}