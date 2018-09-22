package com.example.varun.learningkotlinmvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.varun.learningkotlinmvvm.Adapter.CustomAdapter
import com.example.varun.learningkotlinmvvm.ViewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var customAdapter: CustomAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_write)


        /* recyclerView = findViewById(R.id.recyclerview)

         var userViewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

         userViewModel.getArrayList().observe(this, Observer { userViewModels ->

             customAdapter = CustomAdapter(this, userViewModels!!)
             recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
             recyclerView!!.setAdapter(customAdapter)

         })*/

    }


}
