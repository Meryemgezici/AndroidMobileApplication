package com.meryemgezici.loginpage.service

import com.meryemgezici.loginpage.model.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET


interface UserAPI {
    //https://raw.githubusercontent.com/
    //Meryemgezici/JSONDataSet/main/Users.json

    @GET("Meryemgezici/JSONDataSet/main/Users.json")
    fun getData(): Call<List<User>>
}