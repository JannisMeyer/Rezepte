package com.example.rezepte.recipeDetail

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rezepte.R
import com.example.rezepte.data.Additions
import com.example.rezepte.data.Recipe
import com.example.rezepte.databinding.ActivityRecipeDetailBinding
import com.example.rezepte.editRecipe.EditRecipeActivity
import com.example.rezepte.recipeDatabase.RecipeDBInterface
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeDetailBinding

    //for onActivityResult-functionality
    private val newRecipeActivityRequestCode = 1

    //for comparison of old and new title for possibly needed resort of recipes
    private lateinit var oldTitle : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //connect this activity with corresponding display
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get values from intent from which this activity has been started
        val extras = intent.extras
        val recipeTypeGlobal = extras?.getString("TYPE")
        val recipeIdGlobal = extras?.getString("ID")
        oldTitle = extras?.getString("TITLE").toString()

        binding.editButton.setOnClickListener {
            if (recipeTypeGlobal != null && recipeIdGlobal != null) {

                //create intent and send along recipe attributes
                val intent = Intent(this, EditRecipeActivity::class.java)
                intent.putExtra("TYPE", recipeTypeGlobal)
                intent.putExtra("ID", recipeIdGlobal)
                intent.putExtra("TITLE", extras.getString("TITLE"))
                intent.putExtra("INGREDIENTS", extras.getString("INGREDIENTS"))
                intent.putExtra("DESCRIPTION", extras.getString("DESCRIPTION"))
                startActivityForResult(intent, newRecipeActivityRequestCode)
            }
            else {
                Toast.makeText(this, "intent extra is null! (onCreate() in RecipeDetailActivity)", Toast.LENGTH_SHORT).show()
            }
        }

        //set data from intent to display
        val recipeTitleView: TextView = findViewById(R.id.recipe_detail_title)
        val recipeIngredientsView: TextView = findViewById(R.id.recipe_detail_ingredients)
        val recipeDescriptionView: TextView = findViewById(R.id.recipe_detail_description)

        recipeTitleView.text = extras?.getString("TITLE")
        recipeIngredientsView.text = extras?.getString("INGREDIENTS")
        recipeDescriptionView.text = extras?.getString("DESCRIPTION")
    }

    private fun loadRecipes(recipeType: String): MutableList<Recipe> {

        val dbInterface = RecipeDBInterface(this)
        return dbInterface.readFromDB(recipeType)
    }

    private fun saveRecipes(recipes : MutableList<Recipe>, recipeType: String) {

        val dbInterface = RecipeDBInterface(this)
        dbInterface.writeToDB(recipes, recipeType)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        //handle return of editing recipe activity
        if (requestCode == newRecipeActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let { extra ->
                val recipeTitle = extra.getStringExtra("RECIPE_TITLE")
                val recipeIngredients = extra.getStringExtra("RECIPE_INGREDIENTS")
                val recipeDescription = extra.getStringExtra("RECIPE_DESCRIPTION")
                val recipeType = extra.getStringExtra("RECIPE_TYPE")
                val recipeId = extra.getStringExtra("RECIPE_ID")

                //add edited recipe attributes to recipes
                if (recipeTitle != null && recipeIngredients != null && recipeDescription != null && recipeType != null && recipeId != null) {
                    val recipes : MutableList<Recipe> = loadRecipes(recipeType.toString())

                    for (item in recipes) {
                        if (item.id == recipeId.toInt()) {
                            item.title = recipeTitle
                            item.ingredients = recipeIngredients
                            item.description = recipeDescription
                        }
                    }

                    //resort recipes if needed
                    if(recipeTitle != oldTitle) {
                        recipes.sortBy { it.title }
                    }

                    //save edited recipe and return to parent
                    saveRecipes(recipes, recipeType)
                    finish()
                }
                else {
                    Toast.makeText(this, "Invalid values (null)! (onActivityResult() in RecipeDetailActivity)", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else if (resultCode == Activity.RESULT_CANCELED) {

            //nothing shall happen if child returned by pressing the back button of the device
            ;
        }
        else {
            Toast.makeText(this, "Invalid return of activity! (onActivityResult() in RecipeDetailActivity)", Toast.LENGTH_SHORT).show()
        }
    }
}