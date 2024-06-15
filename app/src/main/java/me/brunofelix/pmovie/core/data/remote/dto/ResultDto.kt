package me.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import me.brunofelix.pmovie.core.domain.model.Movie
import me.brunofelix.pmovie.core.domain.model.MovieDetails

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
    val voteCount: Int?,

    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollectionDto?,

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

    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyDto>?,

    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryDto>?,

    @SerializedName("revenue")
    val revenue: Long?,

    @SerializedName("runtime")
    val runtime: Int?,

    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageDto>?,

    @SerializedName("status")
    val status: String?,

    @SerializedName("tagline")
    val tagline: String?
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
            voteCount = voteCount ?: -1,
            movieDetails = MovieDetails(
                belongsToCollection = belongsToCollection?.toBelongsToCollection(),
                budget = budget ?: -1,
                genres = genres?.map { it.toGenre() },
                homepage = homepage ?: "",
                imdbId = imdbId ?: "",
                originCountry = originCountry ?: emptyList(),
                productionCompanies = productionCompanies?.map { it.toProductionCompany() },
                productionCountries = productionCountries?.map { it.toProductionCountry() },
                revenue = revenue ?: -1,
                runtime = runtime ?: -1,
                spokenLanguages = spokenLanguages?.map { it.toSpokenLanguage() },
                status = status ?: "",
                tagline = tagline ?: ""
            )
        )
    }
}