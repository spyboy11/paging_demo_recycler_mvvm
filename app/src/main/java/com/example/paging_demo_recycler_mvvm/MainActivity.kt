package com.example.paging_demo_recycler_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paging_demo_recycler_mvvm.network.apiUserData

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        //initializing recycler view
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)

            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    private fun initViewModel() {
        val viewModelProvider = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModelProvider.getRecyclerListObserver()?.observe(this, Observer<PagedList<apiUserData>> {
            if (it != null){
                recyclerViewAdapter.submitList(it)
            } else {
                Toast.makeText(this@MainActivity, "Failed to Fetch Data", Toast.LENGTH_LONG).show()
            }
        })
    }
}