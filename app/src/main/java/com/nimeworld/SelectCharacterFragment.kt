package com.nimeworld

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nimeworld.R
import com.nimeworld.adapter.Characterlist_adapter
import com.nimeworld.adapter.OnCharacterClickListener
import com.nimeworld.api.Api
import com.nimeworld.api.ApiService
import com.nimeworld.api.Character
import com.nimeworld.model.Charlist
import kotlinx.android.synthetic.main.fragment_select_character.*
import retrofit2.Call
import retrofit2.Response


class SelectCharacterFragment : Fragment(R.layout.fragment_select_character),OnCharacterClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var animeid = arguments?.getInt("animeid",0)!!
        callcharacter(animeid)
    }
    fun callcharacter(animeid: Int){
        var arrayList:ArrayList<Charlist> = ArrayList()
        var charname = ""
        var role= ""
        var img_url = ""
        var charid = 0
        var count =0
        Api.service<ApiService>().getcharacterlist(animeid).enqueue(object : retrofit2.Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                count = response.body()?.characters!!.size
                for(x in 0 until count ){
                    charname = response.body()?.characters!!.get(x)?.char_name!!
                    role = response.body()?.characters!!.get(x)?.char_role!!
                    charid  = response.body()?.characters!!.get(x)?.char_id!!
                    img_url = response.body()?.characters!!.get(x)?.char_img!!
                    arrayList.add(Charlist(charname,role,img_url,charid))

                }
                callacharacterdapter(arrayList)
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.e("ERROR",t.message.orEmpty())
            }

        })
    }
    fun callacharacterdapter(character: ArrayList<Charlist>){
       RV_choosecharacter.layoutManager = LinearLayoutManager(context)
        RV_choosecharacter.adapter= Characterlist_adapter(character,this)
    }

    override fun OnCharacterclicked(positon: Int, charid: Int) {
        val args = Bundle()
        var fragmentcharacter = SelectedCharacterFragment()
        args.putInt("charid",charid)
        fragmentcharacter.arguments = args
        var fr = fragmentManager?.beginTransaction()
        fr?.replace(R.id.fl_fragmentcontainer, fragmentcharacter)
        fr?.commit()
        fr?.addToBackStack(null)
    }
    }

