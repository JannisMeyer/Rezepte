package com.example.rezepte.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rezepte.R
import com.google.android.material.textfield.TextInputEditText
import com.example.rezepte.databinding.ActivityAddRecipeBinding

const val RECIPE_TITLE = "Titel"
const val RECIPE_INGREDIENTS = "bla\nbla"
const val RECIPE_DESCRIPTION = "Beschreibung"

class AddRecipeActivity : AppCompatActivity() {
    private lateinit var addRecipeTitle: TextInputEditText
    private lateinit var addRecipeIngredients: TextInputEditText
    private lateinit var addRecipeDescription: TextInputEditText

    private lateinit var binding: ActivityAddRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)
        binding = ActivityAddRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.doneButton.setOnClickListener() {
            returnRecipe()
        }
    }

    private fun returnRecipe() {
        val resultIntent = Intent()

        if (binding.addRecipeTitle.text.isNullOrEmpty() || binding.addRecipeIngredients.text.isNullOrEmpty() || binding.addRecipeDescription.text.isNullOrEmpty()) {
            Toast.makeText(this, "Invalid Input (null or empty)!", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val title = binding.addRecipeTitle.text.toString()
            val ingredients = binding.addRecipeIngredients.text.toString()
            val description = binding.addRecipeDescription.text.toString()
            resultIntent.putExtra(RECIPE_TITLE, title)
            resultIntent.putExtra(RECIPE_INGREDIENTS, ingredients)
            resultIntent.putExtra(RECIPE_DESCRIPTION, description)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        Toast.makeText(this, "Finished adding new recipe!", Toast.LENGTH_SHORT).show() //for testing
        finish()
    }
}