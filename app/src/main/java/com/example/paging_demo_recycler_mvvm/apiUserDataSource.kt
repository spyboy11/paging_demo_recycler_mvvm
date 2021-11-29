package com.example.paging_demo_recycler_mvvm

import androidx.paging.PageKeyedDataSource
import com.example.paging_demo_recycler_mvvm.network.RetroInstance
import com.example.paging_demo_recycler_mvvm.network.RetroService_interface
import com.example.paging_demo_recycler_mvvm.network.apiDataClass
import com.example.paging_demo_recycler_mvvm.network.apiUserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class apiUserDataSource(): PageKeyedDataSource<Int, apiUserData>() {

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, apiUserData>) {
        val retroInstance = RetroInstance.getRetrofitInstance().create(RetroService_interface::class.java)
        val call = retroInstance.getDataFromApi(params.key)
        call.enqueue(object: Callback<apiDataClass>{
            override fun onFailure(call: Call<apiDataClass>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<apiDataClass>, response: Response<apiDataClass>) {
                if (response.isSuccessful) {
                    callback.onResult(response?.body()?.results!!, params.key+1)
                }
            }
        })
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, apiUserData>
    ) {
        val retroInstance = RetroInstance.getRetrofitInstance().create(RetroService_interface::class.java)
        val call = retroInstance.getDataFromApi(1)
        call.enqueue(object: Callback<apiDataClass>{
            override fun onFailure(call: Call<apiDataClass>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<apiDataClass>, response: Response<apiDataClass>) {
                if (response.isSuccessful) {
                    callback.onResult(response?.body()?.results!!, null, 50)
                }
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, apiUserData>) {
        TODO("Not yet implemented")
    }
}