package com.meryemgezici.loginpage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class User(

    @ColumnInfo(name="age")
    @SerializedName("age")
    val age: String?,
    @ColumnInfo(name="gender")
    @SerializedName("gender")
    val gender: String?,
    @ColumnInfo(name="image")
    @SerializedName("image")
    val image: String?,
    @ColumnInfo(name="name")
    @SerializedName("name")
    val name: String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0
}
