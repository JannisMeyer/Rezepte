package com.example.rezepte.rezeptDetail

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.rezepte.R
import com.example.rezepte.data.Rezept
import com.example.rezepte.databinding.ActivityRezeptDetailBinding
import com.example.rezepte.editRecipe.EditRecipeActivity
import com.example.rezepte.ui.AddRecipeActivity
import com.example.rezepte.ui.RECIPE_DESCRIPTION
import com.example.rezepte.ui.RECIPE_INGREDIENTS
import com.example.rezepte.ui.RECIPE_TITLE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class RezeptDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRezeptDetailBinding

    private val newRecipeActivityRequestCode = 1

    private lateinit var recipeTypeGlobal : String
    private lateinit var recipeIdGlobal : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRezeptDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val recipeTypeGlobal = extras?.getString("TYPE")
        val recipeIdGlobal = extras?.getString("ID")

        binding.editButton.setOnClickListener {
            if (recipeTypeGlobal != null && recipeIdGlobal != null) {
                val intent = Intent(this, EditRecipeActivity::class.java)
                intent.putExtra("TYPE", recipeTypeGlobal)
                intent.putExtra("ID", recipeIdGlobal)
                intent.putExtra("TITLE", extras.getString("TITEL"))
                intent.putExtra("INGREDIENTS", extras.getString("ZUTATEN"))
                intent.putExtra("DESCRIPTION", extras.getString("BESCHR"))
                startActivityForResult(intent, newRecipeActivityRequestCode)
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
        editor.remove(recipeType)
        editor.putString(recipeType, json)
        editor.commit()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == newRecipeActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let { data ->
                val recipeTitle = data.getStringExtra(RECIPE_TITLE)
                val recipeIngredients = data.getStringExtra(RECIPE_INGREDIENTS)
                val recipeDescription = data.getStringExtra(RECIPE_DESCRIPTION)

                if (recipeTitle != null && recipeIngredients != null && recipeDescription != null) {
                    val recipes : MutableList<Rezept> = loadRecipes(recipeTypeGlobal)

                    for (item in recipes) {
                        if (item.id == recipeIdGlobal.toInt()) {
                            item.Titel = recipeTitle
                            item.Zutaten = recipeIngredients
                            item.Beschreibung = recipeDescription
                        }
                    }
                    saveRecipes(recipes, recipeTypeGlobal)
                }
                else {
                    Toast.makeText(this, "Invalid values (null) (onActivityResult())!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            Toast.makeText(this, "Invalid return of activity (onActivityResult())!", Toast.LENGTH_SHORT).show()
        }
    }
}