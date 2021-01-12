package com.nimeworld

import android.content.Intent
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nimeworld.adapter.OnMovieClickListener
import com.nimeworld.adapter.genrelist_adapter
import com.nimeworld.adapter.movieList_adapter
import com.nimeworld.api.*
import com.nimeworld.model.MovieList
import kotlinx.android.synthetic.main.activity_genre.*
import kotlinx.android.synthetic.main.activity_movie_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_genre.btn_home as btn_home1

class MovieMenuActivity : AppCompatActivity(),OnMovieClickListener {
    private var recyclerView: RecyclerView? = null
    private var movie: ArrayList<MovieList>? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var posteradapter:movieList_adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_menu)
        btn_home.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val type: String? = intent.getStringExtra("menu")
        val genreid: Int = intent.getIntExtra("genreid",0)

        changetitle(type)
        addtoList(type,genreid)
    }
    fun changetitle(type: String?){
        if(type == "genre"){
            tv_title.text = intent.getStringExtra("genrename")
        }
        else if(type=="top"){
            tv_title.text= "TOP ANIME"
        }
    }
     private fun addtoList(type:String?,genreID:Int){
        var arrayList: ArrayList<MovieList> = ArrayList()
        if(type == "genre"){
            Api.service<ApiService>()
                .getmoviegenreList(genreID)
                .enqueue(object : retrofit2.Callback<Anime> {
                    override fun onResponse(call: Call<Anime>, response: Response<Anime>) {
                        var item_count = response.body()?.anime?.size

                        for(x in 0 until item_count!!-1 ){
                            var image_url = response.body()?.anime?.get(x)?.image_url.toString()
                            var id = response.body()?.anime?.get(x)?.anime_id
                            var title = response.body()?.anime?.get(x)?.title
                            arrayList.add(MovieList(id,image_url,title))
                            posteradapter?.notifyDataSetChanged()
                        }
                        movie= arrayList
                        updategrid(type)
                    }
                    override fun onFailure(call: Call<Anime>, t: Throwable) {
                        Log.e("ERROR",t.message.orEmpty())
                    }
                })
        }
        else if(type =="top"){
            Api.service<ApiService>()
                    .gettopanimeList()
                    .enqueue(object : Callback<TopAnime> {
                        override fun onResponse(call: Call<TopAnime>, response: Response<TopAnime>) {
                            var item_count = response.body()?.topanime?.size

                            for(x in 0 until item_count!!-1 ){
                                var image_url = response.body()?.topanime?.get(x)?.image_url.toString()
                                var id = response.body()?.topanime?.get(x)?.anime_id
                                var title = response.body()?.topanime?.get(x)?.title
                                arrayList.add(MovieList(id,image_url,title))
                                posteradapter?.notifyDataSetChanged()
                            }
                            movie= arrayList
                            updategrid(type)
                        }

                        override fun onFailure(call: Call<TopAnime>, t: Throwable) {
                            TODO("Not yet implemented")
                        }


                    })
        }
    }
    fun updategrid(type:String?){
        recyclerView = findViewById(R.id.RV_movielist)
        gridLayoutManager = GridLayoutManager(applicationContext, 3, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        posteradapter = movieList_adapter( movie!!,this)
        recyclerView?.adapter = posteradapter

    }

    override fun onMovieItemClicked(positon: Int,animeid: Int) {
        val intent = Intent(applicationContext,MovieSelectedActivity::class.java)
        intent.putExtra("animeid",animeid)
        startActivity(intent)
    }
}