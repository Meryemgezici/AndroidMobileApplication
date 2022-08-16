package com.meryemgezici.loginpage.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.meryemgezici.loginpage.R
import com.meryemgezici.loginpage.adapter.ViewPagerAdapter

class TabLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        val tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2=findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter= ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager2.adapter=adapter
        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position) {
                0 -> {
                    tab.text = "Employees"
                }
                1->{
                    tab.text = "Courses"
                }
                2->{
                    tab.text = "LOG OUT"
                }
            }
        }.attach()
    }
}

