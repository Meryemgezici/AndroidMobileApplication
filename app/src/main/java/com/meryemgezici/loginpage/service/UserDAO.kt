package com.meryemgezici.loginpage.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meryemgezici.loginpage.model.User
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    //Data Access Object
    @Insert
    suspend fun insertAll(vararg users:User): List<Long>

    @Query("SELECT * FROM user")
    suspend fun getAllUser():List<User>

    @Query("SELECT * FROM user WHERE uuid= :userId")
    suspend fun getUser(userId:Int) : User

    @Query("DELETE FROM user")
    suspend fun deleteAllUser()

}