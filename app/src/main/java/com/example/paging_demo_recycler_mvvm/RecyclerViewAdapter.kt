package com.example.paging_demo_recycler_mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paging_demo_recycler_mvvm.network.DiffUtil
import com.example.paging_demo_recycler_mvvm.network.apiUserData

class RecyclerViewAdapter: PagedListAdapter<apiUserData, RecyclerViewAdapter.ViewHolder>(DiffUtil()) {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val tvFname: TextView = view.findViewById(R.id.tvFname)
        val tvLname: TextView = view.findViewById(R.id.tvLname)
        val tvMail: TextView = view.findViewById(R.id.tvMail)
        val tvImg: ImageView = view.findViewById(R.id.imageThumb)

        fun bind(data: apiUserData){
            tvFname.text = data.first_name
            tvLname.text = data.last_name
            tvMail.text = data.email
            val url = data.avatar

            Glide.with(tvImg)
                .load(url)
                .circleCrop()
                .into(tvImg)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent,false)

        return ViewHolder(inflater)
    }
}