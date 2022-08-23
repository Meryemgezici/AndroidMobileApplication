package com.meryemgezici.loginpage.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context?) {
    //Shared preferences mode
    val PRIVATE_MODE = 0

    //Shared preferences filename
    private val PREF_NAME = "SharedPreferences"
    private val IS_lOGIN = "is_login"

    val pref: SharedPreferences? = context?.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    val editor: SharedPreferences.Editor? = pref?.edit()

    fun setLogin(isLogin: Boolean) {
        editor?.putBoolean(IS_lOGIN, isLogin)
        editor?.commit()
    }

    fun setEmail(email: String?) {
        editor?.putString("email", email)
        editor?.commit()
    }

    fun isLogin(): Boolean? {
        return pref?.getBoolean(IS_lOGIN, false)
    }

    fun getEmail(): String? {
        return pref?.getString("email", "")
    }

    fun removeData() {
        editor?.clear()
        editor?.commit()
    }

}