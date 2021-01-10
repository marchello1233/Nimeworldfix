package com.nimeworld.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nimeworld.R

class genrelist_adapter(private var genrename: List<String>,private var images:List<Int>,private val onGenreClickListener: OnGenreClickListener):RecyclerView.Adapter<genrelist_adapter.ViewHolder>() {
    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val itemPicture: ImageView = itemView.findViewById(R.id.IV_genre)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v = LayoutInflater.from(parent.context).inflate(R.layout.genre_item,parent,false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return genrename.size

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemPicture.setImageResource(images[position])
        var genreid = position+1
        holder.itemView.setOnClickListener{
            onGenreClickListener.onGenreItemClicked(genreid)
        }
    }



}