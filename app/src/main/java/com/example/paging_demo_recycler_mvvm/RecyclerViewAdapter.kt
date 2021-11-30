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

        val tvOriginalTitle: TextView = view.findViewById(R.id.tvOriginal_Title)
        val tvReleaseDate: TextView = view.findViewById(R.id.tvRelease_date)
        val tvPopularity: TextView = view.findViewById(R.id.tv_popularity)
        val tvOriginal_Lang: TextView = view.findViewById(R.id.tvOriginalLang)
        val tvID: TextView = view.findViewById(R.id.tvId)
        val tvImgPoster: ImageView = view.findViewById(R.id.imgPoster)

        /*
        val tvImgPoster: ImageView = view.findViewById(R.id.imgPoster)
        val tvImgPoster: ImageView = view.findViewById(R.id.imgPoster)*/

        fun bind(data: apiUserData){
            tvOriginalTitle.text = data.original_title
            tvReleaseDate.text = data.release_date
            tvPopularity.text = data.popularity
            tvOriginal_Lang.text = data.original_language
            tvID.text = data.id.toString()

            val url = data.backdrop_path

            Glide.with(tvImgPoster)
                .load(url)
                .circleCrop()
                .into(tvImgPoster)
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