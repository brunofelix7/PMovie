package me.brunofelix.pmovie.core.domain.model

data class ProductionCompany(
    val id: Int,
    val name: String,
    val logoPath: String,
    val originCountry: String
)