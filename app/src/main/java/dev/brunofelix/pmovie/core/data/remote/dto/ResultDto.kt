package dev.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import dev.brunofelix.pmovie.core.util.extension.toBackdropUrl
import dev.brunofelix.pmovie.core.util.extension.toPostUrl
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import dev.brunofelix.pmovie.feature.movie.domain.model.MovieDetails

data class ResultDto(
    @SerializedName("id")
    val id: Long?,

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
    val voteAverage: Float?,

    @SerializedName("vote_count")
    val voteCount: Int?,

    @SerializedName("budget")
    val budget: Int?,

    @SerializedName("genres")
    val genres: List<GenreDto>?,

    @SerializedName("homepage")
    val homepage: String?,

    @SerializedName("imdb_id")
    val imdbId: String?,

    @SerializedName("origin_country")
    val originCountry: List<String>?,

    @SerializedName("revenue")
    val revenue: Long?,

    @SerializedName("runtime")
    val runtime: Int?,

    @SerializedName("status")
    val status: String?,

    @SerializedName("tagline")
    val tagline: String?
) {
    fun toMovie(): Movie {
        return Movie(
            id = id ?: -1L,
            title = title ?: "Undefined",
            imageUrl = posterPath?.toPostUrl() ?: "",
            voteAverage = voteAverage ?: -1.0F,
            details = MovieDetails(
                genres = genres?.map { it.toGenre() },
                overview = overview ?: "",
                backdropPath = backdropPath?.toBackdropUrl() ?: "",
                releaseDate = releaseDate ?: "",
                duration = runtime ?: 0,
                voteCount = voteCount ?: 0
            )
        )
    }
}