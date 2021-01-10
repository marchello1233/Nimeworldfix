package com.nimeworld.api


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("genre/anime/{genre_id}")
  fun getmoviegenreList(@Path("genre_id") genre:Int):retrofit2.Call<Anime>
    @GET("top/anime")
    fun gettopanimeList():retrofit2.Call<TopAnime>
}