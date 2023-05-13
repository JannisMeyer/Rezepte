package com.example.rezepte.ui.hauptgerichte

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.adapters.HauptgerichteAdapter
import com.example.rezepte.data.Rezept
import com.example.rezepte.data.Rezepte.Companion.hauptgerichteListe
import com.example.rezepte.data.Rezepte.Companion.test
import com.example.rezepte.databinding.FragmentHauptgerichteBinding
import com.example.rezepte.ui.AddRecipeActivity
import com.example.rezepte.ui.RECIPE_DESCRIPTION
import com.example.rezepte.ui.RECIPE_INGREDIENTS
import com.example.rezepte.ui.RECIPE_TITLE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class HauptgerichteFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHauptgerichteBinding? = null
    private val binding get() = _binding!!

    private val newRecipeActivityRequestCode = 1

    private var mainDishes : MutableList<Rezept>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }

    private fun saveData() {
        val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_main_dishes", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(mainDishes)
        editor.putString("main dishes", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_main_dishes", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("main dishes", null)
        val type : Type = object : TypeToken<MutableList<Rezept>>() {}.type
        mainDishes = gson.fromJson(json, type)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHauptgerichteBinding.inflate(inflater, container, false)
        binding.addButton.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        Toast.makeText(activity, "addButton clicked!", Toast.LENGTH_SHORT).show() //for testing
        val intent = Intent(activity, AddRecipeActivity::class.java)
        startActivityForResult(intent, newRecipeActivityRequestCode)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showRezepte()
    }

    override fun onDestroyView() {
        saveData()
        super.onDestroyView()
        _binding = null
    }

    private fun showRezepte() {
        TODO("combine hauptgerichteListe with saved recipes")
        TODO("how to save data from hauptgerichteListe?")
        val rezepte = hauptgerichteListe

        val recyclerView = binding.hauptgerichteRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HauptgerichteAdapter(rezepte)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        Toast.makeText(context, "addRecipeActivity returned!", Toast.LENGTH_SHORT).show() //for testing
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newRecipeActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val recipeTitle = data.getStringExtra(RECIPE_TITLE)
                val recipeIngredients = data.getStringExtra(RECIPE_INGREDIENTS)
                val recipeDescription = data.getStringExtra(RECIPE_DESCRIPTION)

                if (recipeTitle != null && recipeIngredients != null && recipeDescription != null) {
                    insertRecipe(recipeTitle, recipeIngredients, recipeDescription)
                }
                else {
                    Toast.makeText(activity, "Invalid values (null)!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            Toast.makeText(activity, "Invalid return of activity!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertRecipe(recipeTitle: String, recipeIngredients: String, recipeDescription: String) {

        val newRecipe = Rezept(hauptgerichteListe.size+1, recipeTitle, recipeIngredients, recipeDescription)
        hauptgerichteListe.add(newRecipe)

        //for testing
        Toast.makeText(activity, "insertRecipe() called!", Toast.LENGTH_SHORT).show()
        test = 1;
        binding.textHauptgerichte.text = test.toString()
    }
}
