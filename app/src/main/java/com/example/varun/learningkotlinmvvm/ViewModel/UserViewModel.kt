package com.example.varun.learningkotlinmvvm.ViewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.varun.learningkotlinmvvm.Model.User

class UserViewModel : ViewModel {


    var id = ""
    var name = ""
    var email = ""

    constructor() : super()
    constructor(user: User) : super() {
        this.id = user.id
        this.name = user.name
        this.email = user.email
    }

    constructor(id: String) : super() {
        this.id = id
    }


    var arraylistmutablelivedata = MutableLiveData<ArrayList<UserViewModel>>()
    var arrayList = ArrayList<UserViewModel>()

    fun getArrayList(): MutableLiveData<ArrayList<UserViewModel>> {

        val user1 = User("1", "varun", "v@g.com")
        val user2 = User("2", "silpa", "s@g.com")


        val userViewModel1: UserViewModel = UserViewModel(user1)
        val userViewModel2: UserViewModel = UserViewModel(user2)


        arrayList!!.add(userViewModel1)
        arrayList!!.add(userViewModel2)

        arraylistmutablelivedata.value = arrayList


        return arraylistmutablelivedata
    }

    var usermutablelivedata = MutableLiveData<UserViewModel>()
    
    fun getUser(id: String): MutableLiveData<UserViewModel> {
        val userViewModel1: UserViewModel = UserViewModel("1")
        usermutablelivedata.value = userViewModel1

        return usermutablelivedata
    }

}