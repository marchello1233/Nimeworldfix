package com.nimeworld.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nimeworld.R
import com.nimeworld.api.News
import com.nimeworld.model.MovieList
import com.nimeworld.model.newsList
import kotlinx.android.synthetic.main.moviemenu_item.view.*


class newslist_adapter(private var newslist:ArrayList<newsList>):RecyclerView.Adapter<newslist_adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemtitle: TextView = itemView.findViewById(R.id.tv_newstitle)
        val itemintro: TextView = itemView.findViewById(R.id.tv_intro)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newslist_adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.newsitem,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: newslist_adapter.ViewHolder, position: Int) {
        val news:newsList = newslist.get(position)
        holder.itemtitle.text = news.newstitle
        holder.itemintro.text=news.intro

    }



    override fun getItemCount(): Int {
        return newslist.size
    }
}