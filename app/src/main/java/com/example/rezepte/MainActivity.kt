package com.example.rezepte

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.rezepte.ui.additions.AdditionsFragment
import com.example.rezepte.ui.breads.BreadsFragment
import com.example.rezepte.ui.cakes.CakesFragment
import com.example.rezepte.ui.mainDishes.MainDishesFragment
import com.example.rezepte.ui.salads.SaladsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


//TODO: finish migration from shared preferences to room
//TODO: add proper limiting of scroll views in edit, add and detail recipe activity
//TODO: go to old position in recyclerview after returning from detail recipe
//TODO: solve warnings

//Problems:
// - hang state after going back from detail activity and from editing recipe -> sleep in while-loop fixed that?

class MainActivity : AppCompatActivity() {
    private val mainDishesFragment = MainDishesFragment()
    private val breadsFragment = BreadsFragment()
    private val saladsFragment = SaladsFragment()
    private val additionsFragment = AdditionsFragment()
    private val cakesFragment = CakesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        replaceFragment(mainDishesFragment)

        val bottomNav: BottomNavigationView = findViewById(R.id.nav_view)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_main_dishes -> replaceFragment(mainDishesFragment)
                R.id.navigation_breads -> replaceFragment(breadsFragment)
                R.id.navigation_salads -> replaceFragment(saladsFragment)
                R.id.navigation_additions -> replaceFragment(additionsFragment)
                R.id.navigation_cakes -> replaceFragment(cakesFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragManager: FragmentManager = supportFragmentManager
        val fragTransaction: FragmentTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.main_container, fragment)
        fragTransaction.commit()
    }
}