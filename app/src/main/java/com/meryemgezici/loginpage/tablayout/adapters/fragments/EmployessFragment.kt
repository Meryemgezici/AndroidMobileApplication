package com.meryemgezici.loginpage.tablayout.adapters.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.meryemgezici.loginpage.R
import com.meryemgezici.loginpage.RecyclerAdapter
import com.meryemgezici.loginpage.User

class EmployessFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userList = ArrayList()

        //add userList
        userList.add(User(R.drawable.profile_icon, "Barış Aydın", "Age:29  Gender:male "))
        userList.add(User(R.drawable.profile_icon1, "Meryem Gezici", "Age:22  Gender:female "))
        userList.add(User(R.drawable.profile_icon2, "Ece Su", "Age:20  Gender:female "))
        userList.add(User(R.drawable.profile_icon3, "Yusuf Altın", "Age:25  Gender:male "))
        userList.add(User(R.drawable.profile_icon, "Barış Aydın", "Age:19  Gender:male "))
        userList.add(User(R.drawable.profile_icon1, "Meryem Gezici", "Age:20  Gender:female "))
        userList.add(User(R.drawable.profile_icon2, "Ece Su", "Age:21  Gender:female "))
        userList.add(User(R.drawable.profile_icon3, "Yusuf Altın", "Age:29  Gender:male "))

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_employess, container, false)
        val recyclerView = rootView.findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = LinearLayoutManager(activity);//Linear Items

        recyclerView.adapter = RecyclerAdapter(userList)// struck with here
        recyclerView.layoutManager = LinearLayoutManager(context)
        return rootView
    }

    //return inflater.inflate(R.layout.fragment_employess, container, false)
}