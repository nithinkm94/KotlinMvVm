package com.example.varun.learningkotlinmvvm.db

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.varun.learningkotlinmvvm.Model.User
import com.example.varun.learningkotlinmvvm.Fragment.showSnackbar

class UserRepository {

    private var userDataDao: UserDataDao
    private var mAllUsers: LiveData<List<User>>

    constructor(application: Application) {
        val db = UserDatabase.getDatabase(application)
        this.userDataDao = db.userDataDao()
        this.mAllUsers = userDataDao.getAll()
    }

    companion object {
        var showSnackbar: showSnackbar? = null
    }

    fun getAll(): LiveData<List<User>> {
        return mAllUsers
    }

    fun insert(user: User) {
        insertAsyncTask(userDataDao).execute(user)
    }

    fun searchUser(id: Int): LiveData<User> {
        var user = userDataDao.loadSingle(id)
        if (user == null) {
            showSnackbar!!.show()
        }
        return user
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: UserDataDao) : AsyncTask<User, Void, Void>() {

        override fun doInBackground(vararg params: User): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }

        override fun onPostExecute(result: Void?) {
            if (showSnackbar != null) {
                showSnackbar!!.show()
            }
            super.onPostExecute(result)
        }
    }

}