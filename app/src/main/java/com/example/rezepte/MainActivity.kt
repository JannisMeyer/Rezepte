package com.example.rezepte

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rezepte.databinding.ActivityMainBinding
import com.example.rezepte.ui.brot.BrotFragment
import com.example.rezepte.ui.hauptgerichte.HauptgerichteFragment
import com.example.rezepte.ui.kuchen.KuchenFragment
import com.example.rezepte.ui.salate.SalateFragment
import com.example.rezepte.ui.zusaetze.ZusaetzeFragment

class MainActivity : AppCompatActivity() {
    private val hauptgerichteFragment = HauptgerichteFragment()
    private val broteFragment = BrotFragment()
    private val salateFragment = SalateFragment()
    private val zusaetzeFragment = ZusaetzeFragment()
    private val kuchenFragment = KuchenFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(hauptgerichteFragment)

        val bottom_nav: BottomNavigationView = findViewById(R.id.nav_view)

        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_hauptgerichte -> replaceFragment(hauptgerichteFragment)
                R.id.navigation_brot -> replaceFragment(broteFragment)
                R.id.navigation_salate -> replaceFragment(salateFragment)
                R.id.navigation_zusaetze -> replaceFragment(zusaetzeFragment)
                R.id.navigation_kuchen -> replaceFragment(kuchenFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val fragManager: FragmentManager = supportFragmentManager
            val fragTransaction: FragmentTransaction = fragManager.beginTransaction()
            fragTransaction.replace(R.id.main_container, fragment)
            //fragTransaction.addToBackStack(null)
            fragTransaction.commit()
        }
    }
}