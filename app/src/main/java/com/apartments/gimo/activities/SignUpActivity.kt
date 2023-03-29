package com.apartments.gimo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.apartments.gimo.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setupActionBar()

        val button_sign_up: Button = findViewById(R.id.getPassword_button)
        button_sign_up.setOnClickListener {
            registerUser()
        }
    }

    private fun setupActionBar() {
        val arrowImage: ImageView = findViewById(R.id.arrow_back_image_signUp)

        arrowImage.setOnClickListener{
            startActivity(Intent(this, IntroActivity::class.java))
        }
    }

    private fun registerUser() {

        val et_name = findViewById<EditText>(R.id.editText_signUp_name)
        val et_surname = findViewById<EditText>(R.id.editText_signUp_surname)
        val et_email = findViewById<EditText>(R.id.editText_signUp_email)
        val et_password = findViewById<EditText>(R.id.editText_signUp_password)

        val name = et_name.text.toString().trim()
        val surname = et_surname.text.toString().trim()
        val email = et_email.text.toString().trim()
        val password = et_password.text.toString().trim()


        if(validateForm(name,surname,email,password)) {
            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    hideProgressDialog()
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        val registeredEmail = firebaseUser.email!!
                        Toast.makeText(
                            this, "$name $surname " +
                                    "zarejestrowałeś się poprawnie poprzez adres email $registeredEmail",
                            Toast.LENGTH_LONG
                        ).show()
                        FirebaseAuth.getInstance().signOut()
                        finish()
                    } else {
                        Toast.makeText(
                            this,
                            task.exception!!.message, Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

    }



    private fun validateForm(name: String, surname:String,email: String, password: String): Boolean {

        return when {
            TextUtils.isEmpty(name)->{
                showErrorSnackBar("Proszę wprowadź imię")
                false
            }
            TextUtils.isEmpty(surname)->{
                showErrorSnackBar("Proszę wprowadź nazwisko")
                false
            }
            TextUtils.isEmpty(email)->{
                showErrorSnackBar("Proszę wprowadź adres e-mail")
                false
            }
            TextUtils.isEmpty(password)->{
                showErrorSnackBar("Proszę wprowadź hasło")
                false
            } else -> {
                true
            }
        }
    }


}