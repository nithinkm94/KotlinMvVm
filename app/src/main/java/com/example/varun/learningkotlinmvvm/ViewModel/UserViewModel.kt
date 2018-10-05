package com.example.varun.learningkotlinmvvm.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.varun.learningkotlinmvvm.Model.User
import com.example.varun.learningkotlinmvvm.db.UserRepository
import android.text.Editable


class UserViewModel : AndroidViewModel {


    private lateinit var userRepository: UserRepository

    private var allUsers: LiveData<List<User>>? = null


    fun insert(user: User) {
        userRepository.insert(user)
    }

    fun getArrayList(): LiveData<List<User>> {

        return allUsers!!
    }

    fun setData(name: String, email: String) {
        val user: User = User(null, name, email)

            val addedID = insert(user)
            Log.d("UserViewModel", "Inserted ID $addedID")
        }


    fun searchUser(userId: String): LiveData<User> {

        return userRepository.searchUser(Integer.parseInt(userId))
    }

    var id: Int? = null
    var name: String? = null
    var email: String? = null

    init {
        this.userRepository = UserRepository(getApplication())
        this.allUsers = userRepository!!.getAll()
    }

    constructor(application: Application) : super(Application()) {

    }

    constructor(id: Int?, name: String?, email: String?) : super(Application()) {
        this.id = id
        this.name = name
        this.email = email
    }

}