package com.nimeworld

import android.content.Intent
import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nimeworld.adapter.OnMovieClickListener
import com.nimeworld.adapter.movieList_adapter
import com.nimeworld.api.Anime
import com.nimeworld.api.Api
import com.nimeworld.api.ApiService
import com.nimeworld.api.TopAnime
import com.nimeworld.model.MovieList
import kotlinx.android.synthetic.main.fragment_poster.*
import kotlinx.android.synthetic.main.fragment_poster.tv_title
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentPoster : Fragment(R.layout.fragment_poster),OnMovieClickListener {
    private var recyclerView: RecyclerView? = null
    private var movie: ArrayList<MovieList>? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var posteradapter:movieList_adapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val type: String? = arguments?.getString("menu")
        val genreid: Int = arguments?.getInt("genreid",0)!!
        changetitle(type)
        addtoList(type,genreid)

    }
    fun changetitle(type: String?){
        if(type == "genre"){
            tv_title.text = arguments?.getString("genrename")
        }
        else if(type=="top"){
            tv_title.text= "TOP ANIME"
        }
    }
    fun addtoList(type:String?,genreID:Int){
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
                               if (item_count!! > 0){
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
                                else if (item_count <= 1){
                                    tv_title.text = "no anime found"
                               }
                        }

                        override fun onFailure(call: Call<TopAnime>, t: Throwable) {
                            Log.e("ERROR",t.message.orEmpty())
                        }


                    })
        }
    }
    fun updategrid(type:String?){
        recyclerView = view?.findViewById(R.id.RV_movielist)
        gridLayoutManager = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        posteradapter = movieList_adapter( movie!!,this)
        recyclerView?.adapter = posteradapter

    }
    override fun onMovieItemClicked(positon: Int, animeid: Int) {
        val args = Bundle()
        val Movieselected = MovieSelectedFragment()
        var animeid  = args.putInt("animeid",animeid)
        Movieselected.arguments = args
        var fr = fragmentManager?.beginTransaction()
        fr?.replace(R.id.fl_fragmentcontainer,Movieselected)
        fr?.commit()
        fr?.addToBackStack(null)
    }

}