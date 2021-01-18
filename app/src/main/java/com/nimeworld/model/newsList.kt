package com.nimeworld.model

import com.google.gson.annotations.SerializedName

class newsList {
    var newsurl:String?=null
    var newstitle:String? = null
    var intro:String?=null
    constructor(newsurl:String?,newstitle:String?,intro:String?){
        this.newsurl = newsurl
        this.newstitle = newstitle
        this.intro=intro
    }
}