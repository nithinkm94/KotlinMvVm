package com.example.varun.learningkotlinmvvm.Fragment

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.varun.learningkotlinmvvm.MainActivity
import com.example.varun.learningkotlinmvvm.R
import com.example.varun.learningkotlinmvvm.ViewModel.UserViewModel

class Writefragment : Fragment(), View.OnClickListener {

    private lateinit var btn_back: Button

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_back -> {
                //var userViewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
                mActivity.finish()
            }

            else -> {
            }
        }
    }

    lateinit var mActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity= context as MainActivity
    }

    companion object {
        fun newInstance(): Writefragment {
            return Writefragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater?.inflate(R.layout.fragment_write, container, false)

        btn_back = v.findViewById(R.id.btn_back)
        btn_back.setOnClickListener(this)
        return v
    }

}