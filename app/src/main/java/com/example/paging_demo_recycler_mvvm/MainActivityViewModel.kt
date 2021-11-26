package com.example.paging_demo_recycler_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.paging_demo_recycler_mvvm.network.apiUserData
import java.util.concurrent.Executors

class MainActivityViewModel: ViewModel() {

    private var characterList: LiveData<PagedList<apiUserData>>? = null

    init {
        initPaging()
    }

    private fun initPaging(){
        val factory = apiUserDataSourceFacotry()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(2)
            .build()

        val executor = Executors.newFixedThreadPool(5)
        characterList = LivePagedListBuilder<Int, apiUserData>(factory, config)
            .setFetchExecutor(executor)
            .build()
    }

    fun getRecyclerListObserver(): LiveData<PagedList<apiUserData>>? {
        return characterList
    }
}