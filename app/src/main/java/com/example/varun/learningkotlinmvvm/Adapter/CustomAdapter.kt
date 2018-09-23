package com.example.varun.learningkotlinmvvm.Adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.varun.learningkotlinmvvm.R
import com.example.varun.learningkotlinmvvm.Model.User
import com.example.varun.learningkotlinmvvm.ViewModel.UserViewModel
import com.example.varun.learningkotlinmvvm.databinding.UsersBinding

class CustomAdapter(private val context: Context, private val arrayList: List<User>) : RecyclerView.Adapter<CustomAdapter.CustomView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        val layoutInflater = LayoutInflater.from(parent.context)
        val userBinding: UsersBinding = DataBindingUtil.inflate(layoutInflater, R.layout.userslist_layout, parent, false)
        return CustomView(userBinding)
    }

    override fun getItemCount(): Int {
        var count = arrayList.size
        return arrayList.size
    }


    override fun onBindViewHolder(holder: CustomView, position: Int) {

        val user = arrayList[position]
        var userViewModel = UserViewModel(user.id, user.name, user.email)
        holder.bind(userViewModel)
    }


    class CustomView(val userBinding: UsersBinding) : RecyclerView.ViewHolder(userBinding.root) {

        fun bind(userViewModel: UserViewModel) {


            this.userBinding.usermodel = userViewModel
            userBinding.executePendingBindings()
        }


    }

}