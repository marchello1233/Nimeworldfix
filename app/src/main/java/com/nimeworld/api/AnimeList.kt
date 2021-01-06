package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class AnimeList {
    @SerializedName("mal_id")
    var GenreId: Integer? = null
    @SerializedName("image_url")
    var GenreName: String? = null
}