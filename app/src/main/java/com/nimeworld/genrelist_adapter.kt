package com.nimeworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class genrelist_adapter(private var genrename: List<String>,private var images:List<Int>):RecyclerView.Adapter<genrelist_adapter.ViewHolder>() {
    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.TV_genrename)
        val itemPicture: ImageView = itemView.findViewById(R.id.IV_genre)
        init {
            itemView.setOnClickListener{
                v:View->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,"You Clicked on Item # ${position+1}", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v = LayoutInflater.from(parent.context).inflate(R.layout.genre_item,parent,false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return genrename.size

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.itemTitle.text=genrename[position]

    }



}