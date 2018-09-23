package com.example.varun.learningkotlinmvvm.Fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.varun.learningkotlinmvvm.MainActivity
import com.example.varun.learningkotlinmvvm.Model.User
import com.example.varun.learningkotlinmvvm.R
import com.example.varun.learningkotlinmvvm.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_read.*
import com.example.varun.learningkotlinmvvm.db.UserRepository.Companion.showSnackbar
import java.util.concurrent.Executors

class Readfragment : Fragment(), View.OnClickListener, showSnackbar {
    override fun show() {

        Snackbar.make(
                fragment_read, // Parent view
                "Record Not Found", // Message to show
                Snackbar.LENGTH_SHORT // How long to display the message.
        ).show()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var myExecutor = Executors.newSingleThreadExecutor()
    private lateinit var userViewModel: UserViewModel
    private var mUser: User? = null

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_search -> {
                userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)


                userViewModel.searchUser(ed_idsearch.getText().toString()).observe(this, Observer { mUser ->

                    updateUi(mUser)
                })


            }
        }
    }


    lateinit var mActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity= context as MainActivity
        showSnackbar = null

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
        showSnackbar = this
        super.onViewCreated(view, savedInstanceState)
    }

    private fun updateUi(mUser: User?) {
        if (mUser != null) {
            txt_name.setText(mUser!!.name)
            txt_email.setText(mUser!!.email)
        } else {

            txt_name.setText("")
            txt_email.setText("")
        }
    }

}