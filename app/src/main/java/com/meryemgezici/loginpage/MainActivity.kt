package com.meryemgezici.loginpage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences
        var SharedPreferences = this.getSharedPreferences("users", Context.MODE_PRIVATE)
        var editor = SharedPreferences.edit()
        //add data
        editor.putString("email", "gezicimeryem34@gmail.com").apply()
        editor.putString("password", "Mer1212.").apply()

        preferences = getSharedPreferences("users", MODE_PRIVATE)


    }

    fun loginButton(view: View) {
        var registeredUser = preferences.getString("email", "")
        var registeredPassword = preferences.getString("password", "")

        var loginEmail = emailText.text.toString()
        var loginPassword = passwordText.text.toString()

        if ((registeredUser == loginEmail) && (registeredPassword == loginPassword)) {
            intent = Intent(applicationContext, Homepage::class.java)
            intent.putExtra("email", emailText.text.toString())
            startActivity(intent)
        } else if ((registeredUser != loginEmail) && (registeredPassword != loginPassword)) {
            Toast.makeText(
                applicationContext,
                "Your email and password is incorrect",
                Toast.LENGTH_LONG
            ).show()
        } else if ((registeredUser != loginEmail)) {
            Toast.makeText(applicationContext, "Your email is incorrect", Toast.LENGTH_LONG).show()
        } else if ((registeredPassword != loginPassword)) {
            Toast.makeText(applicationContext, "Your password is incorrect", Toast.LENGTH_LONG)
                .show()
        }


        //finish()
    }

    /*fun showPassword(view:View){
        var isShow=false
        if(isShow){
            passwordText.transformationMethod=PasswordTransformationMethod.getInstance()
            showHidePassword.setImageResource(R.drawable.ic_baseline_visibility_24)
            isShow=true
        }else{
            passwordText.transformationMethod=HideReturnsTransformationMethod.getInstance()
            showHidePassword.setImageResource(R.drawable.ic_baseline_visibility_off_24)
            isShow=false
        }
    }*/
}