package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class selectedNews {
    @SerializedName("url")
    var newsurl:String?=null
    @SerializedName("title")
    var newstitle:String? = null
    @SerializedName("intro")
    var intro:String?=null
    @SerializedName("image_url")
    var image_url:String?=null
}