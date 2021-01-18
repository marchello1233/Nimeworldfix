package com.nimeworld

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_genre.setOnClickListener {
            var fragmentgenre = GenreFragment()
            var fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.fl_fragmentcontainer, fragmentgenre)
            fr?.commit()
            fr?.addToBackStack(null)
        }
        btn_topanime.setOnClickListener {
            val args = Bundle()
            var fragmentmovie = FragmentPoster()
            var fr = fragmentManager?.beginTransaction()
            args.putString("menu","top")
            fragmentmovie.arguments = args
            fr?.replace(R.id.fl_fragmentcontainer, fragmentmovie)
            fr?.commit()
            fr?.addToBackStack(null)
        }

    }

}