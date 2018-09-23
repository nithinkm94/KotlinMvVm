package com.example.varun.learningkotlinmvvm.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.varun.learningkotlinmvvm.Model.User
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface UserDataDao {

    @Query("SELECT * from User")
    fun getAll(): LiveData<List<User>>


    @Query("SELECT * FROM User WHERE id = :id ")
    fun loadSingle(id: Int): User


    @Insert(onConflict = REPLACE)
    fun insert(user: User): Long

    @Query("DELETE from User")
    fun deleteAll()
}