package com.example.varun.learningkotlinmvvm.navigation

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.example.varun.learningkotlinmvvm.ViewModel.ViewModelFactory


class NavigationManager {

    companion object {
        fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, tag: String) {
            supportFragmentManager.inTransaction { add(frameId, fragment, tag).addToBackStack("") }
        }

        fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, className: Class<*>) {
            supportFragmentManager.inTransaction { replace(frameId, fragment, className::class.java.simpleName).addToBackStack("") }
        }

        inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
            beginTransaction().func().commit()
        }

        fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
                ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)

    }

}