package com.nimeworld.adapter

import android.media.Image
import android.speech.RecognitionListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nimeworld.R
import com.nimeworld.model.Charlist
import com.squareup.picasso.Picasso

class Characterlist_adapter(private var characterlist: ArrayList<Charlist>, private val onCharacterClickListener: OnCharacterClickListener): RecyclerView.Adapter<Characterlist_adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemname: TextView = itemView.findViewById(R.id.tv_charactername)
        val itemrole: TextView = itemView.findViewById(R.id.tv_roletext)
        val charpic: ImageView = itemView.findViewById(R.id.IV_characterselect)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Characterlist_adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return Characterlist_adapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Characterlist_adapter.ViewHolder, position: Int) {
        val character = characterlist.get(position)
        holder.itemname.text = character.name
        holder.itemrole.text = character.role
        Picasso.get().load(character.img_url).into(holder.charpic)
        holder.itemView.setOnClickListener{
           onCharacterClickListener.OnCharacterclicked(position,character!!.charid!!)
        }
    }

    override fun getItemCount(): Int {
        return characterlist.size
    }

}