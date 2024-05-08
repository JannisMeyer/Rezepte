package com.example.rezepte

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.rezepte.data.LocalRecipes
import com.example.rezepte.data.MainDishes.Companion.mainDishesList
import com.example.rezepte.data.Recipe
import com.example.rezepte.ui.additions.AdditionsFragment
import com.example.rezepte.ui.breads.BreadsFragment
import com.example.rezepte.ui.cakes.CakesFragment
import com.example.rezepte.ui.mainDishes.MainDishesFragment
import com.example.rezepte.ui.salads.SaladsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


//TODO: finish migration from shared preferences to room -> rework app to use singleton recipe class with all recipes, room accesses only when editing, removing or adding recipe
//TODO: add proper limiting of scroll views in edit, add and detail recipe activity
//TODO: go to old position in recyclerview after returning from detail recipe
//TODO: solve warnings

//Problems:
// - hang state after room accesses

class MainActivity : AppCompatActivity() {
    private val mainDishesFragment = MainDishesFragment()
    private val breadsFragment = BreadsFragment()
    private val saladsFragment = SaladsFragment()
    private val additionsFragment = AdditionsFragment()
    private val cakesFragment = CakesFragment()

    var localRecipes = LocalRecipes.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        replaceFragment(mainDishesFragment)

        localRecipes?.loadAllRecipeData(this)

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

    override fun onDestroy() {

        super.onDestroy()

        localRecipes?.writeAllRecipeData(this)
    }

    private fun moveFromSharedPreferencesToDB() {

        val sharedPreferences : SharedPreferences = getSharedPreferences("saved_recipes", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("main dishes", null)
        val type : Type = object : TypeToken<MutableList<Recipe>>() {}.type
        var mainDishes : MutableList<Recipe> = gson.fromJson(json, type)
        if(mainDishes == null){
            mainDishes = mainDishesList
            //Toast.makeText(activity, "Loaded data is null! (loadData() in MainDishesFragment)", Toast.LENGTH_SHORT).show()
        }
        for (item in mainDishes!!) {
            item.type = "main dish"
        }
    }
}