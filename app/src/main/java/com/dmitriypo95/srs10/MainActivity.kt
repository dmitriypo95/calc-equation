package com.dmitriypo95.srs10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomMenu = findViewById(R.id.bottom_menu)
        bottomMenu.setOnItemSelectedListener{ item->
            when (item.itemId){
                R.id.menu -> {
                    val menuFragment = MenuFragment()
                   replaceFragment(menuFragment)
                }
                R.id.second_activity_button -> {
                    val aboutFragment = AboutFragment()
                    replaceFragment(aboutFragment)
                }
            }
            true
        }
       bottomMenu.selectedItemId = R.id.menu
    }

    private fun replaceFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            //.add(R.id.fragment_container, fragment)
            .commit()
    }
}