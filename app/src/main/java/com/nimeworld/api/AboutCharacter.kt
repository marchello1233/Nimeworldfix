package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class AboutCharacter {
    @SerializedName("name")
    var charname:String?=null
    @SerializedName("about")
    var about_char: String? = null
    @SerializedName("image_url")
    var image_url: String? = null
   @SerializedName("voice_actors")
    var voice_actor: List<voiceactorlist>?=null
}