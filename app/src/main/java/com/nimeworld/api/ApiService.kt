package com.nimeworld.api


import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("genre/anime/{genre_id}")
  fun getmoviegenreList(@Path("genre_id") genre:Int):retrofit2.Call<Anime>
    @GET("top/anime")
    fun gettopanimeList():retrofit2.Call<TopAnime>
    @GET("anime/{id}")
    fun getselectedanime(@Path("id") anime_id:Int):retrofit2.Call<SelectedAnime>
    @GET("anime/{id}/news")
    fun getnews(@Path("id") anime_id:Int):retrofit2.Call<News>
    @GET("anime/{id}/characters_staff")
    fun getcharacterlist(@Path("id") anime_id: Int):retrofit2.Call<Character>
    @GET("character/{id}")
    fun getcharacterinfo(@Path("id")char_id: Int): retrofit2.Call<AboutCharacter>

}