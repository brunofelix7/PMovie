package me.brunofelix.pmovie.core.domain.model

data class Movie(
    val id: Int?,
    val title: String?,
    val originalTitle: String?,
    val originalLanguage: String?,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
    val adult: Boolean?,
    val genreIds: List<Int>?,
    val popularity: Double?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?
)