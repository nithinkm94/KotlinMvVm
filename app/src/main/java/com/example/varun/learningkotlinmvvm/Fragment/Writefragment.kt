package com.example.varun.learningkotlinmvvm.Fragment

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.varun.learningkotlinmvvm.MainActivity
import com.example.varun.learningkotlinmvvm.R
import com.example.varun.learningkotlinmvvm.ViewModel.UserViewModel
import com.example.varun.learningkotlinmvvm.db.UserRepository.Companion.showSnackbar
import kotlinx.android.synthetic.main.fragment_write.*

class Writefragment : Fragment(), View.OnClickListener, showSnackbar {
    override fun show() {

        Snackbar.make(
                fragment_write, // Parent view
                "Inserted", // Message to show
                Snackbar.LENGTH_SHORT // How long to display the message.
        ).show()
        ed_name.setText("")
        ed_email.setText("")

    }

    lateinit var userViewModel: UserViewModel
    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btn_save -> {
                userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

                userViewModel.setData(ed_name.getText().toString(), ed_email.getText().toString())
            }

            else -> {
            }
        }
    }

    lateinit var mActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as MainActivity
        showSnackbar = null
    }

    companion object {
        fun newInstance(): Writefragment {
            return Writefragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_write, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showSnackbar = this
        btn_save.setOnClickListener(this)
        super.onViewCreated(view, savedInstanceState)
    }

}