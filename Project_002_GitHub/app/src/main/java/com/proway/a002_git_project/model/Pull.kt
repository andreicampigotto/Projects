package com.proway.a002_git_project.model

import com.google.gson.annotations.SerializedName

data class Pull(
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("created_at")
    val created_at: String
) {
}