package com.example.varun.learningkotlinmvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.varun.learningkotlinmvvm.Adapter.CustomAdapter
import com.example.varun.learningkotlinmvvm.Fragment.Mainfragment
import com.example.varun.learningkotlinmvvm.Fragment.Writefragment
import com.example.varun.learningkotlinmvvm.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private var ed_name: EditText? = null
    private var ed_email: EditText? = null
    private lateinit var btn_write: Button


    private var recyclerView: RecyclerView? = null
    private var customAdapter: CustomAdapter? = null
    private var userViewModel: UserViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.main, Mainfragment.newInstance())
                .addToBackStack("main")
                .commit()

        /*

        ed_name=findViewById(R.id.ed_name)
        ed_email=findViewById(R.id.ed_email)
        btn_save=findViewById(R.id.btn_save)
        btn_save.setOnClickListener(this)
        userViewModel= ViewModelProviders.of(this).get(UserViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerview)


         userViewModel!!.getArrayList().observe(this, Observer { userViewModels ->

             customAdapter = CustomAdapter(this, userViewModels!!)
             recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
             recyclerView!!.setAdapter(customAdapter)

         })
*/
    }


}
