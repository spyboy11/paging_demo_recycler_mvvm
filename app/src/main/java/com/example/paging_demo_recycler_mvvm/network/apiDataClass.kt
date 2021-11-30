package com.example.paging_demo_recycler_mvvm.network

data class apiDataClass(
    val page: Int,
    val results: ArrayList<apiUserData>
)

data class apiUserData(
    val id: Int,
    val backdrop_path: String, //5 img poster
    val original_language: String, //4
    val original_title: String, //1
    val overview: String,
    val popularity: String, //3
    val poster_path: String,
    val release_date: String, //2

    /*val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String*/
)