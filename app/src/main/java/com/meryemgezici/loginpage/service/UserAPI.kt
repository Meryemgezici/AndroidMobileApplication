package com.meryemgezici.loginpage.service

import com.meryemgezici.loginpage.model.User
import retrofit2.http.GET


interface UserAPI {

    //https://raw.githubusercontent.com/
    //Meryemgezici/JSONDataSet/main/Users.json

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }

    @GET("Meryemgezici/JSONDataSet/main/Users.json")
    //fun getUser(): Single<List<User>>
    suspend fun getUsers():List<User>
}