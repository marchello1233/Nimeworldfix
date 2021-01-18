package com.nimeworld.model

class Charlist {
    var name: String? = null
    var role: String? = null
    var img_url: String?=null
    var charid: Int?=null
    constructor(name:String?,role:String?,img_url:String?,charid:Int?){
        this.name = name
        this.role = role
        this.img_url = img_url
        this.charid = charid
    }
}