package com.nimeworld.model

class MovieList {
    var animeid:Int?=0
    var image_url: String? = null
    var title: String? = null
    constructor(animeid:Int?,image_url:String?,title:String?){
        this.animeid = animeid
        this.image_url = image_url
        this.title= title
    }

}