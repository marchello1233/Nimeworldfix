package com.nimeworld.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nimeworld.R
import com.nimeworld.api.voiceactorlist
import com.nimeworld.model.newsList
import com.nimeworld.model.voiceactorLIst
import com.squareup.picasso.Picasso

class Voiceactorlist_adapter(private var voiecator:ArrayList<voiceactorLIst>):RecyclerView.Adapter<Voiceactorlist_adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val actorname: TextView = itemView.findViewById(R.id.tv_actorname)
        val actorlanguage: TextView = itemView.findViewById(R.id.tv_language)
        val actorphoto: ImageView = itemView.findViewById(R.id.IV_voiceactor)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.voiceactor_item,parent,false)
        return Voiceactorlist_adapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actor:voiceactorLIst = voiecator.get(position)
        holder.actorname.text= actor.name
        holder.actorlanguage.text= actor.language
        Picasso.get().load(actor.imageurl).into(holder.actorphoto)
    }

    override fun getItemCount(): Int {
       return voiecator.size
    }
}
