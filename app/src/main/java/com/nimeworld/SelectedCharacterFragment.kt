package com.nimeworld

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.nimeworld.adapter.Voiceactorlist_adapter
import com.nimeworld.api.AboutCharacter
import com.nimeworld.api.Api
import com.nimeworld.api.ApiService
import com.nimeworld.model.voiceactorLIst
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_selected_character.*
import retrofit2.Call
import retrofit2.Response


class SelectedCharacterFragment : Fragment(R.layout.fragment_selected_character) {
    var voiceactor: ArrayList<voiceactorLIst>? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var characterid = arguments?.getInt("charid",0)!!
        callvoiceactor(characterid)
    }
    fun callvoiceactor(characterid:Int){
        var arrayList:ArrayList<voiceactorLIst> = ArrayList()
        var actorname = ""
        var language = ""
        var imageurl = ""
        var photo = view?.findViewById<ImageView>(R.id.IV_charactername)
        var count = 0
        Api.service<ApiService>().getcharacterinfo(characterid).enqueue(object : retrofit2.Callback<AboutCharacter> {
            override fun onResponse(call: Call<AboutCharacter>, response: Response<AboutCharacter>) {
                tv_charactername.text = response.body()?.charname!!
                tv_details.text = editabout(response.body()?.about_char!!)
                Picasso.get().load(response.body()?.image_url).into(photo)
                count = response.body()?.voice_actor!!.size
                for(x in 0 until count){
                    actorname = response.body()?.voice_actor!!.get(x).actor_name!!
                    language = response.body()?.voice_actor!!.get(x).language!!
                    imageurl = response.body()?.voice_actor!!.get(x).img_url!!
                    arrayList.add(voiceactorLIst(actorname,language,imageurl))
                }
                calladapter(arrayList)
            }

            override fun onFailure(call: Call<AboutCharacter>, t: Throwable) {
                Log.e("ERROR",t.message.orEmpty())
            }

        })
    }
    fun calladapter(actor: ArrayList<voiceactorLIst>){
        RV_voiceactor.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        RV_voiceactor.adapter= Voiceactorlist_adapter(actor)
    }
    fun editabout(about:String): String {
        var aboutchar = about.replace("\\n","")
        return aboutchar
    }
}