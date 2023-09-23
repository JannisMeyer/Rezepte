package com.example.rezepte.addRecipe

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rezepte.R
import com.example.rezepte.databinding.ActivityAddRecipeBinding

class AddRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //connect this activity with corresponding display
        setContentView(R.layout.activity_add_recipe)
        binding = ActivityAddRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set onClickListener for when newly created recipe shall be added
        binding.doneButton.setOnClickListener() {
            if (binding.addRecipeTitle.text.isNullOrEmpty() || binding.addRecipeIngredients.text.isNullOrEmpty() || binding.addRecipeDescription.text.isNullOrEmpty()) {
                Toast.makeText(this, "Feld leer!", Toast.LENGTH_SHORT).show()
            }
            else {
                returnRecipe()
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {

        super.onBackPressed()

        //to control the return by pressing the back button of the device
        setResult(Activity.RESULT_CANCELED, Intent());
    }

    private fun returnRecipe() {

        //create intent and send newly created recipe along
        val resultIntent = Intent()

        val title = binding.addRecipeTitle.text.toString()
        val ingredients = binding.addRecipeIngredients.text.toString()
        val description = binding.addRecipeDescription.text.toString()

        resultIntent.putExtra("RECIPE_TITLE", title)
        resultIntent.putExtra("RECIPE_INGREDIENTS", ingredients)
        resultIntent.putExtra("RECIPE_DESCRIPTION", description)

        //for confirmation by the parent
        setResult(Activity.RESULT_OK, resultIntent)

        //this returns to parent
        finish()
    }
}