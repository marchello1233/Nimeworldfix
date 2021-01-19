package com.nimeworld

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nimeworld.adapter.newslist_adapter
import com.nimeworld.api.Api
import com.nimeworld.api.ApiService
import com.nimeworld.api.News
import com.nimeworld.model.newsList
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Response


class NewsFragment : Fragment(R.layout.fragment_news){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var animeid = arguments?.getInt("animeid",0)!!
        fillnews(animeid)
    }
    fun fillnews(animeid:Int){
        var arrayList:ArrayList<newsList> = ArrayList()
        var newsurl = ""
        var newstitle = ""
        var intro = ""
        var count =0
        Api.service<ApiService>()
                .getnews(animeid)
                .enqueue(object : retrofit2.Callback<News> {
                    override fun onResponse(call: Call<News>, response: Response<News>) {
                        count = response.body()?.articles!!.size
                        if(count > 0){
                            for(x in 0 until count ){
                                newsurl = response.body()?.articles?.get(x)?.newsurl!!
                                newstitle = response.body()?.articles?.get(x)?.newstitle!!
                                intro = response.body()?.articles?.get(x)?.intro!!
                                arrayList.add(newsList(newsurl,newstitle,intro))
                            }
                            calladapter(arrayList)
                        }
                        else if (count <=0){
                            tv_nonews.visibility = View.VISIBLE
                        }

                    }

                    override fun onFailure(call: Call<News>, t: Throwable) {
                        Log.e("ERROR",t.message.orEmpty())
                    }

                })
    }
    fun calladapter(news: ArrayList<newsList>){
        RV_news.layoutManager = LinearLayoutManager(context)
        RV_news.adapter= newslist_adapter(news)
    }

}