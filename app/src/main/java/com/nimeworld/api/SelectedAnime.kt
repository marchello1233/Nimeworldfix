package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class SelectedAnime {
    @SerializedName("title")
    var animetitle:String? = null
    @SerializedName("status")
    var status:String? = null
    @SerializedName("duration")
    var duration:String? = null
    @SerializedName("episodes")
    var episodes:Int? = 0
    @SerializedName("rating")
    var rating:String? = null
    @SerializedName("premiered")
    var premiered:String? = null
    @SerializedName("synopsis")
    var synopsis:String? = null
    @SerializedName("image_url")
    var image_url: String? = null
}