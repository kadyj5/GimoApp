package com.apartments.gimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class IntroActivity : AppCompatActivity() {

//    private val SPLASH_DISPLAY_LENGTH: Long = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

//        Handler(Looper.getMainLooper()).postDelayed({
//            startActivity(Intent(this, StartActivity::class.java))
//            finish()
//        }, 2500.toLong())
    }
}