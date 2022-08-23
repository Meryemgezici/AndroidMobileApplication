package com.meryemgezici.loginpage.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class TimeSharedPreferences {
    companion object {

        private val TIME = "time"
        private var sharedPreferences: SharedPreferences? = null


        @Volatile
        private var instance: TimeSharedPreferences? = null
        private val lock = Any()
        operator fun invoke(context: Context): TimeSharedPreferences =
            instance ?: synchronized(lock) {
                instance ?: createTimeSharedPreferences(context).also {
                    instance = it
                }
            }

        private fun createTimeSharedPreferences(context: Context): TimeSharedPreferences {
            sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return TimeSharedPreferences()
        }


    }

    fun saveTime(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(TIME, time)
        }
    }

    fun getTime() = sharedPreferences?.getLong(TIME, 0)

}