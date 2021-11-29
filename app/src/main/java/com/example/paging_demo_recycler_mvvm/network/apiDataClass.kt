package com.example.paging_demo_recycler_mvvm.network

data class apiDataClass(
    val page: Int,
    val results: ArrayList<apiUserData>
)

data class apiUserData(
    val id: Int,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String, //1
    val overview: String, //2
    val popularity: String, //4
    val poster_path: String,
    val release_date: String, //3

    /*val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String*/
)