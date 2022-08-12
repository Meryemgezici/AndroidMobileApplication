package com.meryemgezici.loginpage.tablayout.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.meryemgezici.loginpage.tablayout.adapters.fragments.EmployessFragment
import com.meryemgezici.loginpage.tablayout.adapters.fragments.CoursesFragment
import com.meryemgezici.loginpage.tablayout.adapters.fragments.LoginFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
            return  when(position){
                0->{
                    EmployessFragment()
                }
                1->{
                    CoursesFragment()
                }
                2->{
                    LoginFragment()
                }
                else->{
                    Fragment()
                }
        }
    }
}