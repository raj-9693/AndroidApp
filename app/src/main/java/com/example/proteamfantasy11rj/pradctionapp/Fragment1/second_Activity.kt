package com.example.proteamfantasy11rj.pradctionapp.Fragment1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.proteamfantasy11rj.pradctionapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class second_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)



        loadFragment(home_Fragment())

        val bottomNavigation:BottomNavigationView=findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){
R.id.nav_home->loadFragment(home_Fragment())
    R.id.nav_profile->loadFragment(profile_Fragment())
        R.id.nav_search->loadFragment(search_fragment())
               else->false
            }
            true
        }

//        loadFragment(home_Fragment())
//
//        // Bottom navigation setup
//        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
//        bottomNavigation.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.nav_home -> loadFragment(home_Fragment())
//                R.id.nav_search -> loadFragment(search_fragment())
//                R.id.nav_profile -> loadFragment(profile_Fragment())
//                else -> false
//            }
//            true
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private  fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
        return true
    }

//    private fun loadFragment(fragment: Fragment): Boolean {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .commit()
//        return true
//    }
}