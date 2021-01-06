package com.nimeworld.api


import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/genre/anime")
  fun getmoviegenreList(
           @Path("genre_id") genre:Int
  ):retrofit2.Call<BaseResponse<List<AnimeList>>>
}