package com.nimeworld.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nimeworld.model.MovieList
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.moviemenu_item.view.*
import com.nimeworld.R
import com.squareup.picasso.Picasso

class MovieList_adapter(var context: Context, var arrayList: ArrayList<MovieList>) :
        RecyclerView.Adapter<MovieList_adapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_movie_menu, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val movielist: MovieList = arrayList.get(position)
        val movieposter = holder.itemView.IV_movie

        Picasso.get()


        holder.icons.setOnClickListener {

        }

    }
    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icons = itemView.findViewById<ImageView>(R.id.IV_movie)

    }
}