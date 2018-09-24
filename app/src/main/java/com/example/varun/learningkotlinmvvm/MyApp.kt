package com.example.varun.learningkotlinmvvm

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.varun.learningkotlinmvvm.db.UserDatabase

class MyApp : Application() {
    companion object {
        var database: UserDatabase? = null

    }

    override fun onCreate() {
        super.onCreate()
        MyApp.database = Room.databaseBuilder(this, UserDatabase::class.java, "user").build()
    }
}