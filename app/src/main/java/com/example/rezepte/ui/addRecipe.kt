package com.example.rezepte.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rezepte.R
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.android.material.textfield.TextInputEditText

const val RECIPE_TITLE = "Titel"
const val RECIPE_INGREDIENTS = "bla\nbla"
const val RECIPE_DESCRIPTION = "Beschreibung"

class AddRecipeActivity : AppCompatActivity() {
    private lateinit var addRecipeTitle: TextInputEditText
    private lateinit var addRecipeIngredients: TextInputEditText
    private lateinit var addRecipeDescription: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_recipe_layout)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addRecipe()
        }
        addRecipeTitle = findViewById(R.id.add_recipe_title)
        addRecipeIngredients = findViewById(R.id.add_recipe_ingredients)
        addRecipeDescription = findViewById(R.id.add_recipe_description)
    }

    private fun addRecipe() {
        val resultIntent = Intent()

        if (addRecipeTitle.text.isNullOrEmpty() || addRecipeIngredients.text.isNullOrEmpty() || addRecipeDescription.text.isNullOrEmpty()) {
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val title = addRecipeTitle.text.toString()
            val ingredients = addRecipeIngredients.text.toString()
            val description = addRecipeDescription.text.toString()
            resultIntent.putExtra(RECIPE_TITLE, title)
            resultIntent.putExtra(RECIPE_INGREDIENTS, ingredients)
            resultIntent.putExtra(RECIPE_DESCRIPTION, description)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }
}