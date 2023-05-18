package com.example.rezepte.rezeptDetail

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.rezepte.R
import com.example.rezepte.data.Rezept
import com.example.rezepte.databinding.ActivityRezeptDetailBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class RezeptDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRezeptDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRezeptDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val recipeType = extras?.getString("TYPE")
        val recipeId = extras?.getString("ID")

        binding.deleteButton.setOnClickListener {
            if (recipeType != null && recipeId != null) {
                deleteRecipe(recipeType, recipeId)
            }
            else {
                Toast.makeText(this, "intent extra is null! (onCreate())", Toast.LENGTH_SHORT).show()
            }
        }

        binding.editButton.setOnClickListener {
            if (recipeType != null && recipeId != null) {
                editRecipe(recipeType, recipeId)
            }
            else {
                Toast.makeText(this, "intent extra is null! (onCreate())", Toast.LENGTH_SHORT).show()
            }
        }

        val recipeTitleView: TextView = findViewById(R.id.rezept_detail_titel)
        val recipeIngredientsView: TextView = findViewById(R.id.rezept_detail_zutaten)
        val recipeDescriptionView: TextView = findViewById(R.id.rezept_detail_beschreibung)

        recipeTitleView.text = extras?.getString("TITEL")
        recipeIngredientsView.text = extras?.getString("ZUTATEN")
        recipeDescriptionView.text = extras?.getString("BESCHR")
    }

    private fun deleteRecipe(recipeType : String, recipeId : String) {
        val recipes : MutableList<Rezept> = loadRecipes(recipeType)

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage("Rezept löschen?")
        alertDialogBuilder.setPositiveButton("Ja") { dialog, which ->
            for (item in recipes) {
                if (item.id == recipeId.toInt()) {
                    recipes.remove(item)
                }
            }
            saveRecipes(recipes, recipeType)
        }
        alertDialogBuilder.setNegativeButton("Nein") { dialog, which ->

        }
        alertDialogBuilder.show()
    }

    private fun editRecipe(recipeType : String, recipeId : String) {
        val recipes : MutableList<Rezept> = loadRecipes(recipeType)

        TODO("edit recipe")

        saveRecipes(recipes, recipeType)
    }

    private fun loadRecipes(recipeType: String): MutableList<Rezept> {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("saved_recipes", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString(recipeType, null)
        val type: Type = object : TypeToken<MutableList<Rezept>>() {}.type
        return gson.fromJson(json, type)
    }

    private fun saveRecipes(recipes : MutableList<Rezept>, recipeType: String) {
        val sharedPreferences : SharedPreferences = this.getSharedPreferences("saved_recipes", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(recipes)
        editor.putString(recipeType, json)
        editor.apply()
    }
}