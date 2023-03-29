package com.apartments.gimo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.apartments.gimo.R

class IntroActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val signInButton:Button = findViewById(R.id.signIn_button)
        val signUpButton:Button = findViewById(R.id.signUp_button)

        signInButton.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java ))
        }
    }
}