package com.meryemgezici.loginpage.service

import com.meryemgezici.loginpage.model.User
import io.reactivex.Single
import retrofit2.http.GET


interface UserAPI {

    //https://raw.githubusercontent.com/
    //Meryemgezici/JSONDataSet/main/Users.json

    @GET("Meryemgezici/JSONDataSet/main/Users.json")
    fun getUser(): Single<List<User>>
    //suspend fun getUser():List<User>
}