package com.nimeworld

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nimeworld.adapter.OnGenreClickListener
import com.nimeworld.adapter.genrelist_adapter
import kotlinx.android.synthetic.main.fragment_genre.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [GenreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GenreFragment : Fragment(R.layout.fragment_genre), OnGenreClickListener {
    private var genrename = mutableListOf<String>("Action","Adventure","Cars","Comedy","Dementia","Demons","Mystery","Drama","Ecchi","Fantasy","Game","Hentai","Historical","Horror","Kids","Magic","Martial Arts","Mecha","Music","Parody","Samurai","Romance","School","Sci-Fi","Shoujo","Shoujo Ai","Shounen","Shounen Ai","Space","Sports","SuperPower","Vampire","Yaoi","Yuri","Harem","Military","Slice of Life","Supernatural","Police","Psychological","Thriller","Seinen","Josei")
    private var imagelist = mutableListOf<Int>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addToList()
        RV_Genrename.layoutManager = LinearLayoutManager(context)
        RV_Genrename.adapter= genrelist_adapter(genrename,imagelist,this)
    }

    private fun addToList(){
        imagelist.add(R.drawable.action)
        imagelist.add(R.drawable.adventure)
        imagelist.add(R.drawable.cars)
        imagelist.add(R.drawable.comedy)
        imagelist.add(R.drawable.dementia)
        imagelist.add(R.drawable.demons)
        imagelist.add(R.drawable.mystery)
        imagelist.add(R.drawable.drama)
        imagelist.add(R.drawable.ecchi)
        imagelist.add(R.drawable.fantasy)
        imagelist.add(R.drawable.game)
        imagelist.add(R.drawable.hentai)
        imagelist.add(R.drawable.historical)
        imagelist.add(R.drawable.horror)
        imagelist.add(R.drawable.kids)
        imagelist.add(R.drawable.magic)
        imagelist.add(R.drawable.martial)
        imagelist.add(R.drawable.meccha)
        imagelist.add(R.drawable.music)
        imagelist.add(R.drawable.parody)
        imagelist.add(R.drawable.samurai)
        imagelist.add(R.drawable.romance)
        imagelist.add(R.drawable.school)
        imagelist.add(R.drawable.scifi)
        imagelist.add(R.drawable.shoujo)
        imagelist.add(R.drawable.shoujoai)
        imagelist.add(R.drawable.shounen)
        imagelist.add(R.drawable.shounenai)
        imagelist.add(R.drawable.space)
        imagelist.add(R.drawable.sport)
        imagelist.add(R.drawable.superpower)
        imagelist.add(R.drawable.vampire)
        imagelist.add(R.drawable.yaoi)
        imagelist.add(R.drawable.yuri)
        imagelist.add(R.drawable.harem)
        imagelist.add(R.drawable.military)
        imagelist.add(R.drawable.sliceoflife)
        imagelist.add(R.drawable.supernatural)
        imagelist.add(R.drawable.police)
        imagelist.add(R.drawable.psychological)
        imagelist.add(R.drawable.thriller)
        imagelist.add(R.drawable.seinen)
        imagelist.add(R.drawable.josei)



    }

    override fun onGenreItemClicked(positon: Int) {
        TODO("Not yet implemented")
    }

}
