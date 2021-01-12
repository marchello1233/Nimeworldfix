package com.nimeworld.adapter

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.moviemenu_item.view.*
import com.nimeworld.R
import com.nimeworld.api.Anime
import com.nimeworld.api.AnimeList
import com.nimeworld.model.MovieList
import com.squareup.picasso.Picasso

class movieList_adapter( var arrayList: ArrayList<MovieList>,private val onmovieclicklistener: OnMovieClickListener) :
        RecyclerView.Adapter<movieList_adapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
                .inflate(R.layout.moviemenu_item, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val movie:MovieList= arrayList.get(position)
        val poster = holder.itemView.IV_movie
       Picasso.get().load(movie.image_url).into(poster)
        holder.title.text = movie.title
        holder.itemView.setOnClickListener{
            onmovieclicklistener.onMovieItemClicked(position,movie.animeid!!)
        }

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var icons = itemView.findViewById<ImageView>(R.id.IV_movie)
        var title = itemView.findViewById<TextView>(R.id.tv_movietitle)

    }
}