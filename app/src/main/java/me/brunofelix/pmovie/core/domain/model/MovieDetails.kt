package me.brunofelix.pmovie.core.domain.model

data class MovieDetails(
    val belongsToCollection: BelongsToCollection?,
    val budget: Int,
    val genres: List<Genre>?,
    val homepage: String,
    val imdbId: String,
    val originCountry: List<String>?,
    val productionCompanies: List<ProductionCompany>?,
    val productionCountries: List<ProductionCountry>?,
    val revenue: Long,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>?,
    val status: String,
    val tagline: String
)