package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class voiceactorlist {
    @SerializedName("name")
    var actor_name: String? = null
    @SerializedName("language")
    var language: String? = null
    @SerializedName("image_url")
    var img_url: String? = null
}