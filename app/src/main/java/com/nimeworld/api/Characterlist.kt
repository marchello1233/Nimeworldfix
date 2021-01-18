package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class Characterlist {
    @SerializedName("mal_id")
    var char_id: Int?= null
    @SerializedName("name")
    var char_name: String? = null
    @SerializedName("role")
    var char_role: String? = null
    @SerializedName("image_url")
    var char_img: String? = null
}