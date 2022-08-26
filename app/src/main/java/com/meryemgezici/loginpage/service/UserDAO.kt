package com.meryemgezici.loginpage.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meryemgezici.loginpage.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    //Data Access Object
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user: List<User>)

    @Query("SELECT * FROM user")
    fun getAllUser(): Flow<List<User>>

   /* @Query("SELECT * FROM user WHERE uuid= :userId")
    suspend fun getUser(userId: Int): User*/

    @Query("DELETE FROM user")
    suspend fun deleteAllUser()

}