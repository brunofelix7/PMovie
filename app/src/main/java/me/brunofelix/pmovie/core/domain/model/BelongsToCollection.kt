package me.brunofelix.pmovie.core.domain.model

data class BelongsToCollection(
    val id: Int,
    val name: String,
    val posterPath: String,
    val backdropPath: String
)