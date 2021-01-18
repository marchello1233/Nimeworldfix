package com.nimeworld.api

import com.google.gson.annotations.SerializedName

class News {
    @SerializedName("articles")
    var articles:List<selectedNews>?=null
}