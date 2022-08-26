package com.meryemgezici.loginpage.service


import androidx.room.Database
import androidx.room.RoomDatabase
import com.meryemgezici.loginpage.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO

    //Singleton
    /*companion object {

        @Volatile
        private var instance: UserDatabase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            UserDatabase::class.java, "user"
        ).build()

    }*/

}





