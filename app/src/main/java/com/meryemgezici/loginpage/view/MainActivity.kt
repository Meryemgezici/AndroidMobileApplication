package com.meryemgezici.loginpage.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.meryemgezici.loginpage.R
import com.meryemgezici.loginpage.databinding.ActivityMainBinding
import com.meryemgezici.loginpage.sharedPreferences.Preferences

class MainActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginEmail: String
    private lateinit var loginPassword: String
    private  lateinit var binding:ActivityMainBinding

    private var validEmail = "gezicimeryem34@gmail.com"
    private var validPassword = "Mer1212."

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*//SharedPreferences
        var SharedPreferences = this.getSharedPreferences("users", Context.MODE_PRIVATE)
        var editor = SharedPreferences.edit()
        //add data
        editor.putString("email", "gezicimeryem34@gmail.com").apply()
        editor.putString("password", "Mer1212.").apply()

        preferences1 = getSharedPreferences("users", MODE_PRIVATE)*/

        init()
        checkLogin()


    }

    private fun init() {
        preferences = Preferences(this)
        email = findViewById(R.id.emailText)
        password = findViewById(R.id.passwordText)
    }

    private fun checkLogin() {
        if (preferences.isLogin()!!) {
            intent = Intent(this, Homepage::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun loginButton(view: View) {

        loginEmail = binding.emailText.text.toString()
        loginPassword = binding.passwordText.text.toString()

        if ((validEmail == loginEmail) && (validPassword == loginPassword)) {
            preferences.setLogin(true)
            preferences.setEmail(loginEmail)
            intent = Intent(applicationContext, Homepage::class.java)
            intent.putExtra("email", binding.emailText.text.toString())
            startActivity(intent)
            finish()
        } else if ((validEmail != loginEmail) && (validPassword != loginPassword)) {
            Toast.makeText(
                applicationContext,
                "Your email and password is incorrect",
                Toast.LENGTH_LONG
            ).show()
        } else if ((validEmail != loginEmail)) {
            Toast.makeText(applicationContext, "Your email is incorrect", Toast.LENGTH_LONG).show()
        } else if ((validPassword != loginPassword)) {
            Toast.makeText(applicationContext, "Your password is incorrect", Toast.LENGTH_LONG)
                .show()
        }
    }
}