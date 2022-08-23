package com.meryemgezici.loginpage.repository

import androidx.room.withTransaction
import com.meryemgezici.loginpage.service.UserAPI
import com.meryemgezici.loginpage.service.UserDatabase
import com.meryemgezici.loginpage.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserAPI,
    private val db: UserDatabase
) {
   /* private val userDao = db.userDao()

     fun getUsers() = networkBoundResource(
        query = {
            userDao.getAllUser()
        },
        fetch = {
            delay(2000)
            api.getUser()
        },
        saveFetchResult = { users ->
            db.withTransaction {
                userDao.deleteAllUser()
                userDao.insertAll(users)
            }
        }
    )*/
}