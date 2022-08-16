package com.meryemgezici.loginpage.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("age")
    val age: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String

)
