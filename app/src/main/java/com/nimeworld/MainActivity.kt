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
        val homefragment = HomeFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragmentcontainer,homefragment)
            commit()
        }
        btn_home.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragmentcontainer,homefragment)
                commit()
            }
        }
    }
}

