package com.example.varun.learningkotlinmvvm.Adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.varun.learningkotlinmvvm.R
import com.example.varun.learningkotlinmvvm.ViewModel.UserViewModel
import com.example.varun.learningkotlinmvvm.databinding.UserBinding

class CustomAdapter(private val context: Context, private val arrayList: ArrayList<UserViewModel>) : RecyclerView.Adapter<CustomAdapter.CustomView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        val layoutInflater = LayoutInflater.from(parent.context)

        val userBinding: UserBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_write, parent, false)
        return CustomView(userBinding)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

        val userViewModel = arrayList[position]
        holder.bind(userViewModel)
    }


    class CustomView(val userBinding: UserBinding) : RecyclerView.ViewHolder(userBinding.root) {

        fun bind(userViewModel: UserViewModel) {


            this.userBinding.usermodel = userViewModel
            userBinding.executePendingBindings()
        }


    }

}