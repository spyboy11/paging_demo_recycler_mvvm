package com.example.paging_demo_recycler_mvvm.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService_interface {

    @GET("users")    //users?page=2
    fun getDataFromApi(@Query("page") page: Int): Call<apiDataClass>
}