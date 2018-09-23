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

    var myExecutor = Executors.newSingleThreadExecutor()

    var id: Long? = null
    var name: String? = null
    var email: String? = null

    constructor() : super() {
        this.userRepository = UserRepository(application = Application())
        this.allUsers = userRepository!!.getAll()
    }


    constructor(id: Long?, name: String?, email: String?) : super() {
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

    var usermutablelivedata = MutableLiveData<UserViewModel>()


    fun getArrayList(): LiveData<List<User>> {

        return allUsers!!
    }


    fun getUser(id: Long): MutableLiveData<UserViewModel> {

        var userView: UserViewModel? = null

        val singleUser = "" /*              userDatabase?.userDataDao()?.loadSingle(id)*/

        if (singleUser == null) {
            Log.d("UserViewModel", "NULL")
        } else {
            // userView = UserViewModel(singleUser)
            usermutablelivedata.value = userView
        }

        return usermutablelivedata
    }

    fun setData(name: String, email: String) {
        var user: User = User(null, name, email)
        myExecutor.execute {

            val addedID = insert(user)
            Log.d("UserViewModel", "Inserted ID $addedID")
        }

    }

}