package com.example.paging_demo_recycler_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.paging_demo_recycler_mvvm.network.apiUserData


class apiUserDataSourceFacotry(): DataSource.Factory<Int, apiUserData>() {

    private var mutableLiveData: MutableLiveData<apiUserDataSource>? = null

    init {
        mutableLiveData = MutableLiveData()
    }

    override fun create(): DataSource<Int, apiUserData> {
        val userDataSource = apiUserDataSource()
        mutableLiveData?.postValue(userDataSource)
        return userDataSource
    }
}