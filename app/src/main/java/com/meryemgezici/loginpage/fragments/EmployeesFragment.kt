package com.meryemgezici.loginpage.fragments

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.meryemgezici.loginpage.adapter.RecyclerAdapter
import com.meryemgezici.loginpage.databinding.FragmentEmployeesBinding
import com.meryemgezici.loginpage.model.User
import com.meryemgezici.loginpage.util.ConnectionNetwork
import com.meryemgezici.loginpage.viewmodel.UserListViewModel

//@AndroidEntryPoint
class EmployeesFragment : Fragment() {

    private lateinit var viewModel: UserListViewModel
    private val recyclerAdapter = RecyclerAdapter(arrayListOf())
    private lateinit var binding: FragmentEmployeesBinding
    private lateinit var cld: ConnectionNetwork

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEmployeesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[UserListViewModel::class.java]
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = recyclerAdapter

        checkNetworkConnection()
        observeLiveData()

    }

    fun observeLiveData() {
        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            users?.let {
                binding.recyclerView.visibility = View.VISIBLE
                recyclerAdapter.userListUpdate(users)
            }
        })

        viewModel.userErrorMessage.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if (it) {
                    binding.textViewError.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                } else {
                    binding.textViewError.visibility = View.GONE
                }
            }
        })

        viewModel.userLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                if (it) {
                    binding.recyclerView.visibility = View.GONE
                    binding.textViewError.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.GONE
                }
            }
        })

    }

    private fun checkNetworkConnection() {
        cld = ConnectionNetwork(requireActivity().application)

        cld.observe(viewLifecycleOwner, Observer { isConnected ->

            if (isConnected) {
                viewModel.refreshFromInternet()

            } else {
                viewModel.refreshData()
            }

        })
    }
}






