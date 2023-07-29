package com.example.rezepte.editRecipe

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rezepte.R
import com.example.rezepte.data.Rezept
import com.example.rezepte.databinding.ActivityEditRecipeBinding
import com.example.rezepte.databinding.ActivityRezeptDetailBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class EditRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityEditRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val recipeType = extras?.getString("TYPE")
        val recipeId = extras?.getString("ID")

        binding.doneButton.setOnClickListener {
            if (recipeType != null && recipeId != null) {
                returnRecipe()
            }
            else {
                Toast.makeText(this, "intent extra is null! (onCreate())", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun returnRecipe() {
        //TODO: return recipe from user input
    }
}
