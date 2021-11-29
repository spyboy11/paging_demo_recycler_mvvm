package com.example.paging_demo_recycler_mvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object{
        val baseUrl = "https://api.themoviedb.org/3/movie/" //top_rated?api_key=ae7a6878f877a48fb63853582fa3d034&language=en-US&page=1

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}