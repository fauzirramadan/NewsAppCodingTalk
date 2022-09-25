package com.example.newsappkotlin.network

import com.example.newsappkotlin.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ConfigNetwork {
    companion object {
        fun setupRetrofit(): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
        fun request() = setupRetrofit().create(NewsService::class.java)
    }
}