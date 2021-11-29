package com.example.paging_demo_recycler_mvvm.network

import androidx.recyclerview.widget.DiffUtil
import com.example.paging_demo_recycler_mvvm.network.apiUserData


//this class extend with diffutil
class DiffUtil: DiffUtil.ItemCallback<apiUserData>(){
    override fun areItemsTheSame(oldItem: apiUserData, newItem: apiUserData): Boolean {
        return oldItem.original_title == newItem.original_title
    }

    override fun areContentsTheSame(oldItem: apiUserData, newItem: apiUserData): Boolean {
        return oldItem.original_title == newItem.original_title && oldItem.release_date == newItem.release_date
    }
}