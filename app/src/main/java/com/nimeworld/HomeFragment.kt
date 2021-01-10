package com.nimeworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*


var menuoption = ""



class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_genre.setOnClickListener {
            var fragmentgenre = GenreFragment()
            var fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.fl_fragmentcontainer,fragmentgenre)
            fr?.commit()
            fr?.addToBackStack(null)
        }
        btn_topanime.setOnClickListener {
            menuoption = "top"
            
        }

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(menuop:String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(menuoption, menuop)
                    }
                }
    }
}