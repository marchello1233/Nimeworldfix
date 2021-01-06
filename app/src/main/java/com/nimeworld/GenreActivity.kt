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
    private var genrename = mutableListOf<String>("Action","Adventure","Cars","Comedy","Dementia","Demons","Mystery","Drama","Ecchi","Fantasy","Game","Hentai","Historical","Horror","Kids","Magic","MartialArts","Mecha","Music","Parody","Samurai","Romance","School","Sci-Fi","Shoujo","ShoujoAi","Shounen","ShounenAi","Space","Sports","SuperPower","Vampire","Yaoi","Yuri","Harem","Military","SliceofLife","Supernatural","Police","Psychological","Thriller","Seinen","Josei")
    private var imagelist = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
        RV_Genrename.layoutManager = LinearLayoutManager(this)
        RV_Genrename.adapter= genrelist_adapter(genrename,imagelist,this)
    }

    override fun onGenreItemClicked(position: Int) {
        val intent = Intent(this, MovieMenuActivity::class.java)
        intent.putExtra("menu","genre")
        intent.putExtra("genreid",position)
        intent.putExtra("genrename",genrename[position-1])
        startActivity(intent)

    }
}
