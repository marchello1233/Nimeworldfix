package com.nimeworld

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.nimeworld.api.Api
import com.nimeworld.api.ApiService
import com.nimeworld.api.SelectedAnime
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_selected.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieSelectedFragment : Fragment(R.layout.fragment_movie_selected) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var animeid = arguments?.getInt("animeid",0)!!
        fillinformation(animeid)
        btn_character.setOnClickListener {
            var fr = fragmentManager?.beginTransaction()
            val fragmenselectcharacter = SelectCharacterFragment()
            val args = Bundle()
            var animeid = args.putInt("animeid",animeid)
          fragmenselectcharacter.arguments = args
            fr?.replace(R.id.fl_fragmentcontainer, fragmenselectcharacter)
            fr?.commit()
            fr?.addToBackStack(null)
        }
        btn_news.setOnClickListener {
            var fr = fragmentManager?.beginTransaction()
            val fragmentnews = NewsFragment()
            val args = Bundle()
            var animeid = args.putInt("animeid",animeid)
            fragmentnews.arguments = args
            fr?.replace(R.id.fl_fragmentcontainer, fragmentnews)
            fr?.commit()
            fr?.addToBackStack(null)

        }
    }
    fun fillinformation(animeid:Int){
        Api.service<ApiService>()
                .getselectedanime(animeid)
                .enqueue(object : Callback<SelectedAnime> {
                    override fun onResponse(call: Call<SelectedAnime>, response: Response<SelectedAnime>) {
                        var poster = view?.findViewById<ImageView>(R.id.IV_poster)
                        tv_animeTitle.text = response.body()?.animetitle?.trim()
                        tv_statusname.text= response.body()?.status
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