package me.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import me.brunofelix.pmovie.core.domain.model.ProductionCountry

data class ProductionCountryDto(
    @SerializedName("iso_3166_1")
    val iso31661: String?,

    @SerializedName("name")
    val name: String?
) {
    fun toProductionCountry(): ProductionCountry {
        return ProductionCountry(
            iso31661 = iso31661 ?: "",
            name = name ?: "--"
        )
    }
}