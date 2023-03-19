package com.apartments.gimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class IntroActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH: Long = 2500
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, StartActivity::class.java))
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}