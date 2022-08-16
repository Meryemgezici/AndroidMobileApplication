package com.meryemgezici.loginpage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meryemgezici.loginpage.R
import com.meryemgezici.loginpage.fragments.EmployeesFragment
import com.meryemgezici.loginpage.model.User

class RecyclerAdapter(private val userList: ArrayList<User>, employessFragment: EmployeesFragment) :
    RecyclerView.Adapter<RecyclerAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileView: ImageView = itemView.findViewById(R.id.profileView)
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val ageText: TextView = itemView.findViewById(R.id.ageText)
        val genderText: TextView = itemView.findViewById(R.id.genderText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        //holder.profileView.setImageResource(user.image)
        holder.nameText.text = user.name
        holder.ageText.text = user.age
        holder.genderText.text = user.gender

        Glide.with(holder.itemView.context).load(user.image)
            .into(holder.profileView)


    }

    override fun getItemCount(): Int {
        return userList.size
    }
}