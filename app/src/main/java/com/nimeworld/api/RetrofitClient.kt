package com.nimeworld.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL="https://api.jikan.moe/v3/"
    private val okHttpClient=OkHttpClient.Builder()
        .retryOnConnectionFailure(retryOnConnectionFailure = true)
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun retrofitBuilder(): Retrofit{
        return retrofit
    }

}