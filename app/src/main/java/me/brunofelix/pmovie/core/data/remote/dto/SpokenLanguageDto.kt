package me.brunofelix.pmovie.core.data.remote.dto

import com.google.gson.annotations.SerializedName
import me.brunofelix.pmovie.core.domain.model.SpokenLanguage

data class SpokenLanguageDto(
    @SerializedName("name")
    val name: String?,

    @SerializedName("english_name")
    val englishName: String?,

    @SerializedName("iso_639_1")
    val iso6391: String?
) {
    fun toSpokenLanguage(): SpokenLanguage {
        return SpokenLanguage(
            name = name ?: "--",
            englishName = englishName ?: "--",
            iso6391 = iso6391 ?: "--"
        )
    }
}