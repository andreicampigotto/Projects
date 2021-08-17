package com.proway.project001.model

import com.google.gson.annotations.SerializedName

data class Beer(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("image_url")
    val image_url: String?,
    @SerializedName("ibu")
    val ibu: Double?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("first_brewed")
    val first_brewed: String?,
    @SerializedName("ph")
    val ph: Double?,
    @SerializedName("abv")
    val abv: Double?,
)
