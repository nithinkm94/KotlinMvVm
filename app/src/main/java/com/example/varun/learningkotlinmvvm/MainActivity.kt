package com.example.varun.learningkotlinmvvm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.varun.learningkotlinmvvm.Fragment.Mainfragment
import com.example.varun.learningkotlinmvvm.Fragment.Writefragment
import com.example.varun.learningkotlinmvvm.navigation.NavigationManager.Companion.addFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(Mainfragment.newInstance(), R.id.main, "")

        /*supportFragmentManager
                .beginTransaction()
                .add(R.id.main, Mainfragment.newInstance())
                .addToBackStack("main")
                .commit()
*/
    }


}
