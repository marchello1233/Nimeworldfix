package com.nimeworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.nimeworld.adapter.OnMovieClickListener
import com.nimeworld.api.AnimeList
import com.nimeworld.api.Api
import com.nimeworld.api.ApiService
import com.nimeworld.api.SelectedAnime
import kotlinx.android.synthetic.main.activity_movie_selected.*
import kotlinx.android.synthetic.main.fragment_poster.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.squareup.picasso.Picasso


class MovieSelectedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_selected)
        var animeid = intent.getIntExtra("animeid",0)
        filldetailtitle()
        fillinformation(animeid)
        btn_character.setOnClickListener {

        }
        btn_news.setOnClickListener {

        }
    }
    fun filldetailtitle(){
        tv_duration.text = "Duration :"
        tv_episode.text = "Episodes :"
        tv_producer.text = "Producer :"
        tv_status.text = "Status :"
        tv_rating.text = "Rating :"
    }
    fun fillinformation(animeid:Int){
        Api.service<ApiService>()
                .getselectedanime(animeid)
                .enqueue(object : Callback<SelectedAnime> {
                    override fun onResponse(call: Call<SelectedAnime>, response: Response<SelectedAnime>) {
                        var poster = findViewById<ImageView>(R.id.IV_poster)
                        tv_animeTitle.text = response.body()?.animetitle.toString()
                        tv_statusname.text= response.body()?.status.toString()
                        tv_durationname.text = response.body()?.duration
                        tv_ratingname.text = response.body()?.rating
                        tv_producername.text= response.body()?.premiered
                        tv_synopsisfill.text =response.body()?.synopsis
                        Picasso.get().load(response.body()?.image_url).into(poster)
                    }

                    override fun onFailure(call: Call<SelectedAnime>, t: Throwable) {
                        Log.e("ERROR",t.message.orEmpty())
                    }

                })
    }
}



