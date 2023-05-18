package com.example.rezepte.editRecipe

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.example.rezepte.data.Rezept
import java.lang.reflect.Type

class EditRecipeActivity {

}

private fun loadRecipes(recipeType: String): MutableList<Rezept> {
    val sharedPreferences: SharedPreferences = this.getSharedPreferences("saved_recipes",
        AppCompatActivity.MODE_PRIVATE
    )
    val gson = Gson()
    val json = sharedPreferences.getString(recipeType, null)
    val type: Type = object : TypeToken<MutableList<Rezept>>() {}.type
    return gson.fromJson(json, type)
}

private fun saveRecipes(recipes : MutableList<Rezept>, recipeType: String) {
    val sharedPreferences : SharedPreferences = this.getSharedPreferences("saved_recipes",
        AppCompatActivity.MODE_PRIVATE
    )
    val editor = sharedPreferences.edit()
    val gson = Gson()
    val json = gson.toJson(recipes)
    editor.putString(recipeType, json)
    editor.apply()
}