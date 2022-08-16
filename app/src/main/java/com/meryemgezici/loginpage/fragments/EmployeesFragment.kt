package com.meryemgezici.loginpage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.meryemgezici.loginpage.R
import com.meryemgezici.loginpage.adapter.RecyclerAdapter
import com.meryemgezici.loginpage.model.User
import com.meryemgezici.loginpage.service.UserAPI
import kotlinx.android.synthetic.main.fragment_employees.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EmployeesFragment : Fragment() {


    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var userList: ArrayList<User>? = null
    private var recyclerViewAdapter: RecyclerAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadData()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_employees, container, false)
        val recyclerView = rootView.findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.layoutManager = LinearLayoutManager(activity);//Linear Items

        recyclerView.adapter = userList?.let { RecyclerAdapter(it, this) }// struck with here
        recyclerView.layoutManager = LinearLayoutManager(context)

        return rootView
    }

    private fun loadData() {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(UserAPI::class.java)

        val call = retrofit.getData()
        call.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {

                if (response.isSuccessful) {
                    response.body()?.let {
                        userList = ArrayList(it)
                        userList?.let {
                            recyclerViewAdapter = RecyclerAdapter(it, this@EmployeesFragment)
                            recyclerView.adapter = recyclerViewAdapter

                        }

                    }
                }
            }
        })
    }


    //return inflater.inflate(R.layout.fragment_employess, container, false)
}