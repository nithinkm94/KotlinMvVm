package com.example.varun.learningkotlinmvvm.Fragment

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.varun.learningkotlinmvvm.MainActivity
import com.example.varun.learningkotlinmvvm.Model.User
import com.example.varun.learningkotlinmvvm.R
import com.example.varun.learningkotlinmvvm.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_read.*
import java.util.concurrent.Executors

class Readfragment : Fragment(), View.OnClickListener {

    private var myExecutor = Executors.newSingleThreadExecutor()
    private lateinit var userViewModel: UserViewModel
    private var mUser: User? = null

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_search -> {
                userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

                myExecutor.execute {
                    mUser = userViewModel.searchUser(ed_idsearch.getText().toString())


                }


            }

        }
    }

    lateinit var mActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity= context as MainActivity
    }

    companion object {
        fun newInstance(): Readfragment {
            return Readfragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_read,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btn_search.setOnClickListener(this)

        super.onViewCreated(view, savedInstanceState)
    }
}