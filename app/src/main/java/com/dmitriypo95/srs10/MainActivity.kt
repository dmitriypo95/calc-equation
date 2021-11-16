package com.dmitriypo95.srs10

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


val resultCalcList: MutableList<History> = mutableListOf()

class MainActivity : AppCompatActivity() {
    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomMenu = findViewById(R.id.bottom_menu)
        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    val menuFragment = MenuFragment()
                    replaceFragment(menuFragment)
                }
                R.id.second_activity_button -> {
                    val aboutFragment = AboutFragment()
                    replaceFragment(aboutFragment)
                }
                R.id.send_email_button ->{
                    val emailIntent = Intent(ACTION_SEND)
                    emailIntent.data = Uri.parse("mailto: example@example.com")
                    emailIntent.type = "text/plaint"

                    try {
                        //start email intent
                        startActivity(Intent.createChooser(emailIntent, "Choose Email Client..."))
                    }
                    catch (e: Exception){
                        Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
            true
        }
        bottomMenu.selectedItemId = R.id.menu
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }
}