package com.example.varun.learningkotlinmvvm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.varun.learningkotlinmvvm.Fragment.Readfragment
import com.example.varun.learningkotlinmvvm.Fragment.navigation.NavigationManager.Companion.addFragment
import com.example.varun.learningkotlinmvvm.Fragment.navigation.NavigationManager.Companion.obtainViewModel
import com.example.varun.learningkotlinmvvm.ViewModel.MainActivityViewModel
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    private fun getViewModel(): MainActivityViewModel = obtainViewModel(MainActivityViewModel::class.java)

}
