package me.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import me.brunofelix.pmovie.core.domain.model.ProductionCompany

data class ProductionCompanyDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("logo_path")
    val logoPath: String?,

    @SerializedName("origin_country")
    val originCountry: String?
) {
    fun toProductionCompany(): ProductionCompany {
        return ProductionCompany(
            id = id ?: -1,
            name = name ?: "--",
            logoPath = logoPath ?: "",
            originCountry = originCountry ?: ""
        )
    }
}