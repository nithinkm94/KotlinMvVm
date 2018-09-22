package com.example.varun.learningkotlinmvvm.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.varun.learningkotlinmvvm.Model.User


@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDataDao(): UserDataDao

    companion object {
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase? {
            if (INSTANCE == null) {
                synchronized(UserDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase::class.java, "user.db")
                            .build()
                }
            }
            return INSTANCE

        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }


}