package com.apartments.gimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar;

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        setupActionBar()
    }

    private fun setupActionBar() {
        val arrowImage: ImageView = findViewById(R.id.arrow_back_image)
        arrowImage.setOnClickListener{
            startActivity(Intent(this, IntroActivity::class.java))
        }
    }

}