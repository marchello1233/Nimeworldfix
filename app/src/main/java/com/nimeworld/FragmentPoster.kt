package com.nimeworld

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nimeworld.adapter.movieList_adapter
import com.nimeworld.api.Anime
import com.nimeworld.api.Api
import com.nimeworld.api.ApiService
import com.nimeworld.api.TopAnime
import com.nimeworld.model.MovieList
import kotlinx.android.synthetic.main.fragment_poster.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentPoster : Fragment(R.layout.fragment_poster) {

}