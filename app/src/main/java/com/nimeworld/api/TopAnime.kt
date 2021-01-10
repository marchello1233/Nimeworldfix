package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class TopAnime {
    @SerializedName("top")
    var topanime: List<AnimeList>? =null
}