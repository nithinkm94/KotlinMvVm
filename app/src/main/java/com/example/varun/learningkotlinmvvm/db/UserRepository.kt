package com.example.varun.learningkotlinmvvm.db

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.varun.learningkotlinmvvm.Model.User

class UserRepository {

    private lateinit var userDataDao: UserDataDao
    private lateinit var mAllUsers: LiveData<List<User>>

    constructor(application: Application) {
        val db = UserDatabase.getDatabase(application)
        this.userDataDao = db.userDataDao()
        this.mAllUsers = userDataDao.getAll()
    }


    internal fun getAll(): LiveData<List<User>> {
        return mAllUsers
    }

    fun insert(user: User) {
        insertAsyncTask(userDataDao).execute(user)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: UserDataDao) : AsyncTask<User, Void, Void>() {

        override fun doInBackground(vararg params: User): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }

}