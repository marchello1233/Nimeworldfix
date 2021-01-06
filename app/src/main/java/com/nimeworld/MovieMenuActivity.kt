package com.nimeworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.buildSpannedString
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nimeworld.adapter.MovieList_adapter
import com.nimeworld.api.Api
import com.nimeworld.api.ApiService
import com.nimeworld.model.MovieList
import kotlinx.android.synthetic.main.activity_movie_menu.*

class MovieMenuActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList: ArrayList<MovieList>?=null
    private var movieListAdapters: MovieList_adapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_menu)
        val type: String? = intent.getStringExtra("menu")
        val genreid: Int = intent.getIntExtra("genreid",0)
        checkandfilllist(type,genreid)
    }
    fun checkandfilllist(type:String?,genreID:Int){
        if(type == "genre"){
            tv_title.text=intent.getStringExtra("genrename")
            Api.service<ApiService>()
                .getmoviegenreList(genreID)

        }
        else if(type=="top"){
            tv_title.text= "TOP ANIME"
        }

    }
}