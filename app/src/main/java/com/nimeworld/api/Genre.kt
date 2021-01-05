package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class Genre {
    @SerializedName("name")
    var GenreName: String? = null
    @SerializedName("mal_id")
    var GenreId: Integer? = null
}