package me.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import me.brunofelix.pmovie.core.domain.model.Movie

data class ResultDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("original_title")
    val originalTitle: String?,

    @SerializedName("original_language")
    val originalLanguage: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("release_date")
    val releaseDate: String?,

    @SerializedName("adult")
    val adult: Boolean?,

    @SerializedName("genre_ids")
    val genreIds: List<Int>?,

    @SerializedName("popularity")
    val popularity: Double?,

    @SerializedName("video")
    val video: Boolean?,

    @SerializedName("vote_average")
    val voteAverage: Double?,

    @SerializedName("vote_count")
    val voteCount: Int?
) {
    fun toMovie(): Movie {
        return Movie(
            id = id ?: -1,
            title = title ?: "Undefined",
            originalTitle = originalTitle ?: "Undefined",
            originalLanguage = originalLanguage ?: "",
            overview = overview ?: "",
            posterPath = posterPath ?: "",
            backdropPath = backdropPath ?: "",
            releaseDate = releaseDate ?: "0000-00-00",
            adult = adult ?: false,
            genreIds = genreIds ?: emptyList(),
            popularity = popularity ?: -1.0,
            video = video ?: false,
            voteAverage = voteAverage ?: -1.0,
            voteCount = voteCount ?: -1
        )
    }
}