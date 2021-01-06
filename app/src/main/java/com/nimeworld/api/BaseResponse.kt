package com.nimeworld.api

import com.google.gson.annotations.SerializedName

open class BaseResponse<T> {
    @SerializedName( "request_hash")
    var RequestHash: String? = null
    @SerializedName( "request_cached")
    var Requestcached: String? = null
    @SerializedName( "request_cache_expiry")
    var RequestCacheExpiry: Int? = null
    @SerializedName("mal_url")
    var mal_url: T? = null
    @SerializedName("item_count")
    var genre_item_count : Int? = null
    @SerializedName("anime")
    var anime_list: T? = null
}