package com.nimeworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nimeworld.api.ApiService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var moviemenu:String?=null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_genre.setOnClickListener {
            val intent = Intent(this, GenreActivity::class.java)
            startActivity(intent)
        }
        btn_topanime.setOnClickListener {
            val intent = Intent(this, MovieMenuActivity::class.java)
            startActivity(intent)
        }
    }
}

