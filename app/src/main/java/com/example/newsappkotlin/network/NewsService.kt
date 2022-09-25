package com.example.newsappkotlin.network

import com.example.newsappkotlin.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("everything")
    fun getNews(
        @Query("q") q : String,
        @Query("from") from : String,
        @Query("sortBy") sortBy : String,
        @Query("apiKey") apiKey : String
    ) : Call<ResponseData>
}