package com.meryemgezici.loginpage.adapter

/*import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meryemgezici.loginpage.R
import com.meryemgezici.loginpage.model.User
import com.meryemgezici.loginpage.util.downloadingImage
import com.meryemgezici.loginpage.util.makePlaceholder

class RecyclerAdapter(val userList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileView: ImageView = itemView.findViewById(R.id.profileView)
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val ageText: TextView = itemView.findViewById(R.id.ageText)
        val genderText: TextView = itemView.findViewById(R.id.genderText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameText.text = user.name
        holder.ageText.text = user.age
        holder.genderText.text = user.gender

        // Glide.with(holder.itemView.context).load(user.image)
        //     .into(holder.profileView)
        holder.profileView.downloadingImage(
            userList[position].image,
            makePlaceholder(holder.itemView.context)
        )

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun userListUpdate(newUserList: List<User>) {
        userList.clear()
        userList.addAll(newUserList)
        notifyDataSetChanged()
    }
}*/

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meryemgezici.loginpage.databinding.ItemLayoutBinding
import com.meryemgezici.loginpage.model.User

class RecyclerAdapter :
    ListAdapter<User, RecyclerAdapter.UserViewHolder>(UserComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = getItem(position)

        if(currentItem !=null){
            holder.bind(currentItem)
        }

    }

    class UserViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(user:User){
                binding.apply {
                    Glide.with(itemView)
                        .load(user.image)
                        .into(profileView)

                     nameText.text =user.name
                     ageText.text=user.age
                     genderText.text= user.gender
                }
            }

    }


    class UserComparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User) =
            oldItem.uuid == newItem.uuid

        override fun areContentsTheSame(oldItem: User, newItem: User) =
            oldItem == newItem
    }
}
