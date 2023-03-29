package com.apartments.gimo.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.apartments.gimo.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

open class BaseActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false
    private val exitToast by lazy {
        Toast.makeText(this, "Naciśnij jeszcze raz żeby wyjść", Toast.LENGTH_SHORT)
    }
    private lateinit var mProgressDialog: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showProgressDialog(text: String) {

        mProgressDialog = Dialog(this)
        mProgressDialog.setContentView(R.layout.dialog_progress)
        mProgressDialog.setCancelable(false)
        mProgressDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val progressText = mProgressDialog.findViewById<TextView>(R.id.tv_progress_text)
        progressText.text = text
        mProgressDialog.show()
    }

    fun hideProgressDialog() {
        mProgressDialog.dismiss()
    }

    fun getCurrentUserID(): String {
        return FirebaseAuth.getInstance().currentUser!!.uid
    }

    fun doubleBackExit() {
        if (doubleBackToExitPressedOnce) {
            onBackPressedDispatcher.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        exitToast.show()

        Handler(Looper.getMainLooper()).postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)
    }

    override fun onBackPressed() {
        doubleBackExit()
    }

    fun showErrorSnackBar(message: String) {
        val snackBar = Snackbar.make(findViewById(android.R.id.content),
            message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(this,
            R.color.snackBarColorError))
        snackBar.view
    }

}