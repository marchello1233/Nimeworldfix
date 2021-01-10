package com.nimeworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.nimeworld.adapter.OnGenreClickListener
import com.nimeworld.adapter.genrelist_adapter
import kotlinx.android.synthetic.main.activity_genre.*

class GenreActivity : AppCompatActivity(),OnGenreClickListener {
    private var genrename = mutableListOf<String>("Action","Adventure","Cars","Comedy","Dementia","Demons","Mystery","Drama","Ecchi","Fantasy","Game","Hentai","Historical","Horror","Kids","Magic","Martial Arts","Mecha","Music","Parody","Samurai","Romance","School","Sci-Fi","Shoujo","Shoujo Ai","Shounen","Shounen Ai","Space","Sports","SuperPower","Vampire","Yaoi","Yuri","Harem","Military","Slice of Life","Supernatural","Police","Psychological","Thriller","Seinen","Josei")
    private var imagelist = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)

    }

    override fun onGenreItemClicked(position: Int) {
        val intent = Intent(this, MovieMenuActivity::class.java)
        intent.putExtra("menu","genre")
        intent.putExtra("genreid",position)
        intent.putExtra("genrename",genrename[position-1])
        startActivity(intent)

    }
    private fun addToList(){
        imagelist.add(R.drawable.action)
        imagelist.add(R.drawable.adventure)
        imagelist.add(R.drawable.cars)
        imagelist.add(R.drawable.comedy)
        imagelist.add(R.drawable.dementia)
        imagelist.add(R.drawable.demons)
        imagelist.add(R.drawable.mystery)
        imagelist.add(R.drawable.drama)
        imagelist.add(R.drawable.ecchi)
        imagelist.add(R.drawable.fantasy)
        imagelist.add(R.drawable.game)
        imagelist.add(R.drawable.hentai)
        imagelist.add(R.drawable.historical)
        imagelist.add(R.drawable.horror)
        imagelist.add(R.drawable.kids)
        imagelist.add(R.drawable.magic)
        imagelist.add(R.drawable.martial)
        imagelist.add(R.drawable.meccha)
        imagelist.add(R.drawable.music)
        imagelist.add(R.drawable.parody)
        imagelist.add(R.drawable.samurai)
        imagelist.add(R.drawable.romance)
        imagelist.add(R.drawable.school)
        imagelist.add(R.drawable.scifi)
        imagelist.add(R.drawable.shoujo)
        imagelist.add(R.drawable.shoujoai)
        imagelist.add(R.drawable.shounen)
        imagelist.add(R.drawable.shounenai)
        imagelist.add(R.drawable.space)
        imagelist.add(R.drawable.sport)
        imagelist.add(R.drawable.superpower)
        imagelist.add(R.drawable.vampire)
        imagelist.add(R.drawable.yaoi)
        imagelist.add(R.drawable.yuri)
        imagelist.add(R.drawable.harem)
        imagelist.add(R.drawable.military)
        imagelist.add(R.drawable.sliceoflife)
        imagelist.add(R.drawable.supernatural)
        imagelist.add(R.drawable.police)
        imagelist.add(R.drawable.psychological)
        imagelist.add(R.drawable.thriller)
        imagelist.add(R.drawable.seinen)
        imagelist.add(R.drawable.josei)



    }

}
