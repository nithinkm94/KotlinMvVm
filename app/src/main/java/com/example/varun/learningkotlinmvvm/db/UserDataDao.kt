package com.example.varun.learningkotlinmvvm.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.varun.learningkotlinmvvm.Model.User
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface UserDataDao {

    @Query("SELECT * from User")
    fun getAll(): List<User>


    @Query("SELECT * FROM User WHERE id = :id ")
    fun loadSingle(id: Long): User


    @Insert(onConflict = REPLACE)
    fun insert(user: User)

    @Query("DELETE from User")
    fun deleteAll()
}