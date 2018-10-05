package com.example.varun.learningkotlinmvvm.Fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.varun.learningkotlinmvvm.MainActivity
import com.example.varun.learningkotlinmvvm.R
import kotlinx.android.synthetic.main.fragment_main.*
import com.example.varun.learningkotlinmvvm.navigation.NavigationManager.Companion.replaceFragment
import com.example.varun.learningkotlinmvvm.navigation.NavigationManager.Companion.addFragment

class Mainfragment : Fragment(), View.OnClickListener {


    lateinit var mActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as MainActivity
    }

    companion object {
        fun newInstance(): Mainfragment {
            return Mainfragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btn_write!!.setOnClickListener(this)
        btn_read!!.setOnClickListener(this)
        btn_readall!!.setOnClickListener(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_write -> {
                mActivity.replaceFragment(Writefragment.newInstance(), R.id.main, Writefragment.javaClass)

            }

            R.id.btn_read -> {
                mActivity.replaceFragment(Readfragment.newInstance(), R.id.main, Readfragment.javaClass)

                /* mActivity.supportFragmentManager
                         .beginTransaction()
                         .replace(R.id.main, Readfragment.newInstance())
                         .addToBackStack("")
                         .commit()*/
            }

            R.id.btn_readall -> {

                mActivity.replaceFragment(ReadAllfragment.newInstance(), R.id.main, ReadAllfragment.javaClass)

                /* mActivity.supportFragmentManager
                         .beginTransaction()
                         .replace(R.id.main, ReadAllfragment.newInstance())
                         .addToBackStack("")
                         .commit()*/
            }
        }
    }




}