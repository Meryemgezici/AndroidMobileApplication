package com.meryemgezici.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.activity_main.*

class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        //get intent
        val intent=intent
        val email=intent.getStringExtra("email")

        homepageText.text="Hello "+email+" ,welcome to the homepage"
    }

    fun nextButton(view: View){
        intent= Intent(applicationContext,TabLayout::class.java)
        startActivity(intent)
    }
}