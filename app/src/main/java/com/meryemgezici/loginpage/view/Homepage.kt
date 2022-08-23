package com.meryemgezici.loginpage.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.meryemgezici.loginpage.R
import com.meryemgezici.loginpage.sharedPreferences.Preferences

class Homepage : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private lateinit var email: String
    private lateinit var homepageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        init()
        checkLogin()
        setupUI()
    }

    private fun init() {
        preferences = Preferences(this)
        email = preferences.getEmail().toString()
        homepageTextView = findViewById(R.id.homepageText)
    }

    private fun checkLogin() {
        if (preferences.isLogin() == false) {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupUI() {
        homepageTextView.text = "Hello ${email},welcome to the homepage"
    }


    fun nextButton(view: View) {
        intent = Intent(applicationContext, TabLayout::class.java)
        startActivity(intent)
    }

    fun clickLogout(view: View) {
        preferences.removeData()
        if (preferences.isLogin() == false) {
            val intent = Intent(
                this, MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }

}