package com.example.varun.learningkotlinmvvm.ViewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import android.view.View
import com.example.varun.learningkotlinmvvm.Model.User
import com.example.varun.learningkotlinmvvm.db.UserDatabase
import java.util.logging.Logger

class UserViewModel : ViewModel {

    private var userDatabase: UserDatabase? = null

    private var user: User? = null

    var id: Long? = null
    var name = ""
    var email = ""

    constructor() : super()
    constructor(user: User) : super() {
        this.id = user.id
        this.name = user.name
        this.email = user.email
    }

    constructor(id: Long) : super() {
        this.id = id
    }


    var arraylistmutablelivedata = MutableLiveData<ArrayList<UserViewModel>>()
    var usermutablelivedata = MutableLiveData<UserViewModel>()



    fun getArrayList(): MutableLiveData<ArrayList<UserViewModel>> {
        var arrayList = ArrayList<UserViewModel>()


        var userView: UserViewModel? = null

        val allusers =
                userDatabase?.userDataDao()?.getAll()

        if (allusers == null || allusers?.size == 0) {
            Log.d("UserViewModel", "NULL")
        } else {

            for (i in allusers) {
                userView = UserViewModel(i)
                arrayList.add(userView)

            }

        }
        /* val user1 = User(1, "varun", "v@g.com")
         val user2 = User(2, "silpa", "s@g.com")


         val userViewModel1: UserViewModel = UserViewModel(user1)
         val userViewModel2: UserViewModel = UserViewModel(user2)


         arrayList!!.add(userViewModel1)
         arrayList!!.add(userViewModel2)*/

        arraylistmutablelivedata.value = arrayList


        return arraylistmutablelivedata
    }


    fun getUser(id: Long): MutableLiveData<UserViewModel> {

        var userView: UserViewModel? = null

        val singleUser =
                userDatabase?.userDataDao()?.loadSingle(id)

        if (singleUser == null) {
            Log.d("UserViewModel", "NULL")
        } else {
            userView = UserViewModel(singleUser)
            usermutablelivedata.value = userView
        }

        return usermutablelivedata
    }

    fun setData(name: String, email: String) {
        var user: User = User(null, name, email)
        val addedID = userDatabase?.userDataDao()?.insert(user)
        Log.d("vehicle_lsit_item", "Inserted ID $addedID")
    }

}