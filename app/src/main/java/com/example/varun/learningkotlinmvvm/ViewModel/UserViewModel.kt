package com.example.varun.learningkotlinmvvm.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import android.view.View
import com.example.varun.learningkotlinmvvm.Model.User
import com.example.varun.learningkotlinmvvm.MyApp
import com.example.varun.learningkotlinmvvm.db.UserDatabase
import com.example.varun.learningkotlinmvvm.db.UserRepository
import org.jetbrains.anko.doAsync
import java.util.concurrent.Executors
import java.util.logging.Logger

class UserViewModel : ViewModel {

    private lateinit var userRepository: UserRepository

    private var allUsers: LiveData<List<User>>? = null


    var id: Int? = null
    var name: String? = null
    var email: String? = null

    constructor() : super() {
        this.userRepository = UserRepository(application = Application())
        this.allUsers = userRepository!!.getAll()
    }


    constructor(id: Int?, name: String?, email: String?) : super() {
        this.id = id
        this.name = name
        this.email = email
    }


    internal fun getAll(): LiveData<List<User>> {
        return allUsers!!
    }

    fun insert(user: User) {
        userRepository.insert(user)
    }

    fun getArrayList(): LiveData<List<User>> {

        return getAll()
    }


    fun getUser(id: Int): User {

        var mUser: User = userRepository.searchUser(id)
        return mUser

    }

    fun setData(name: String, email: String) {
        var user: User = User(null, name, email)

            val addedID = insert(user)
            Log.d("UserViewModel", "Inserted ID $addedID")
        }


    fun searchUser(userId: String): User {

        return getUser(Integer.parseInt(userId))
    }

}