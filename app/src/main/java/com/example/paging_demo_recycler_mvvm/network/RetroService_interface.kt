package com.example.paging_demo_recycler_mvvm.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService_interface {

    @GET("top_rated?api_key=ae7a6878f877a48fb63853582fa3d034&language=en-US&")    //top_rated?api_key=ae7a6878f877a48fb63853582fa3d034&language=en-US&page=1
    fun getDataFromApi(@Query("page") page: Int): Call<apiDataClass> //https://image.tmdb.org/t/p/w185/oyG9TL7FcRP4EZ9Vid6uKzwdndz.jpg
}