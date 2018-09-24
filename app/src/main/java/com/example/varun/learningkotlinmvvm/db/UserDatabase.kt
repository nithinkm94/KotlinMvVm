package com.example.varun.learningkotlinmvvm.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import com.example.varun.learningkotlinmvvm.Model.User
import com.example.varun.learningkotlinmvvm.MyApp


@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDataDao(): UserDataDao


    companion object {

        private var INSTANCE: UserDatabase? = null
        fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {
                synchronized(UserDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Create database here
                        INSTANCE = MyApp.database/*Room.databaseBuilder<UserDatabase>(context,
                            UserDatabase::class.java!!, "user")
                            .build()*/
                }
            }
        }
            return INSTANCE!!
        }

    }





}