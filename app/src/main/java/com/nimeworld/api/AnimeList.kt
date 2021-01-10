package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class AnimeList {
    @SerializedName("mal_id")
    var anime_id: Int? = null
    @SerializedName("image_url")
    var image_url: String? = null
    @SerializedName("title")
    var title:String? = null
}