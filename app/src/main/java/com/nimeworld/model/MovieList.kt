package com.nimeworld.model

class MovieList{
    var icons:Int
    var filmlist: String? = null
    constructor(icons:Int,filmlist:String?){
        this.filmlist= filmlist
        this.icons = icons
    }
}