package com.example.paging_demo_recycler_mvvm.network

data class apiDataClass(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: ArrayList<apiUserData>
)

data class apiUserData(
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)