package com.example.rezepte.editRecipe

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rezepte.databinding.ActivityEditRecipeBinding

class EditRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityEditRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val recipeType = extras?.getString("TYPE")
        val recipeId = extras?.getString("ID")
        val recipeTitle = extras?.getString("TITLE")
        val recipeIngredients = extras?.getString("INGREDIENTS")
        val recipeDescription = extras?.getString("DESCRIPTION")

        binding.editRecipeTitle.setText(recipeTitle)
        binding.editRecipeIngredients.setText(recipeIngredients)
        binding.editRecipeDescription.setText(recipeDescription)

        binding.doneButton.setOnClickListener {
            if (recipeType != null && recipeId != null) {
                returnRecipe(recipeType, recipeId)
            }
            else {
                Toast.makeText(this, "intent extra is null! (onCreate() in EditRecipeActivity)", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun returnRecipe(type : String, id: String) {
        val resultIntent = Intent()

        if (binding.editRecipeTitle.text.isNullOrEmpty() || binding.editRecipeIngredients.text.isNullOrEmpty() || binding.editRecipeDescription.text.isNullOrEmpty()) {
            Toast.makeText(this, "Ungültige Eingabe!", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val title = binding.editRecipeTitle.text.toString()
            val ingredients = binding.editRecipeIngredients.text.toString()
            val description = binding.editRecipeDescription.text.toString()
            resultIntent.putExtra("RECIPE_TITLE", title)
            resultIntent.putExtra("RECIPE_INGREDIENTS", ingredients)
            resultIntent.putExtra("RECIPE_DESCRIPTION", description)
            resultIntent.putExtra("RECIPE_TYPE", type)
            resultIntent.putExtra("RECIPE_ID", id)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }
}
