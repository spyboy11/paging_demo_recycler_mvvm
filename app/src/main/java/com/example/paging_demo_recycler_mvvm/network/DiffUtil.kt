package com.example.paging_demo_recycler_mvvm.network

import androidx.recyclerview.widget.DiffUtil
import com.example.paging_demo_recycler_mvvm.network.apiUserData


//this class extend with diffutil
class DiffUtil: DiffUtil.ItemCallback<apiUserData>(){
    override fun areItemsTheSame(oldItem: apiUserData, newItem: apiUserData): Boolean {
        return oldItem.first_name == newItem.first_name
    }

    override fun areContentsTheSame(oldItem: apiUserData, newItem: apiUserData): Boolean {
        return oldItem.first_name == newItem.first_name && oldItem.last_name == newItem.last_name
    }
}