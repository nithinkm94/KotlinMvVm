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

class Mainfragment : Fragment(), View.OnClickListener {


    private lateinit var btn_write: Button

    private lateinit var btn_read: Button

    private lateinit var btn_readall: Button

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_write -> {
                mActivity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main, Writefragment.newInstance())
                        .commit()
                /*userViewModel!!.setData(ed_name!!.text.toString(),ed_email!!.text.toString())
                ed_name!!.text=null
                ed_email!!.text=null*/
            }

            R.id.btn_read -> {
                mActivity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main, Readfragment.newInstance())
                        .commit()
            }

            R.id.btn_readall -> {
                mActivity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main, ReadAllfragment.newInstance())
                        .commit()
            }
        }
    }

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
        val view = inflater?.inflate(R.layout.fragment_main, container, false)
        val btn_write: Button? = view?.findViewById(R.id.btn_write)
        val btn_read: Button? = view?.findViewById(R.id.btn_read)
        val btn_readall: Button? = view?.findViewById(R.id.btn_readall)
        btn_write!!.setOnClickListener(this)
        btn_read!!.setOnClickListener(this)
        btn_readall!!.setOnClickListener(this)
        return view
    }


}