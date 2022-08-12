package com.meryemgezici.loginpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val userList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileView: ImageView = itemView.findViewById(R.id.profileView)
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val userInformationText: TextView = itemView.findViewById(R.id.userInformationText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.profileView.setImageResource(user.image)
        holder.nameText.text = user.name
        holder.userInformationText.text = user.informationUser

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}