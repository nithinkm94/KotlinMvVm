package com.example.varun.learningkotlinmvvm.Fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.varun.learningkotlinmvvm.Adapter.ReadAllAdapter
import com.example.varun.learningkotlinmvvm.MainActivity
import com.example.varun.learningkotlinmvvm.R
import com.example.varun.learningkotlinmvvm.ViewModel.UserViewModel
import com.example.varun.learningkotlinmvvm.navigation.NavigationManager.Companion.obtainViewModel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_readall.*


class ReadAllfragment:Fragment(){
     lateinit var mActivity: MainActivity
    private var readAllAdapter: ReadAllAdapter? = null
    private var userViewModel: UserViewModel? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity= context as MainActivity
    }
    companion object {
        fun newInstance(): ReadAllfragment {
            return ReadAllfragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        userViewModel = mActivity.obtainViewModel(UserViewModel::class.java)

        //userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        userViewModel!!.getArrayList().observe(this, Observer { userViewModels ->

            readAllAdapter = ReadAllAdapter(mActivity, userViewModels!!)
            recycler_listdata!!.layoutManager = LinearLayoutManager(mActivity) as RecyclerView.LayoutManager?
            recycler_listdata!!.setAdapter(readAllAdapter)


        })
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_readall, container, false)
    }


}