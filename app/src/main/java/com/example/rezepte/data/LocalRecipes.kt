package com.example.rezepte.data

import android.content.Context
import com.example.rezepte.recipeDatabase.RecipeDBInterface

class LocalRecipes {
    @Volatile
    private var instance : LocalRecipes? = null
    private var context: Context? = null

    fun getInstance(contextParam : Context): LocalRecipes? {

        if (instance == null) {
            synchronized(this) {
                if (instance == null) {
                    instance = LocalRecipes()
                }
            }
        }
        context = contextParam
        return instance
    }

    var localRecipes = mutableListOf<Recipe>()

    fun getAdditionRecipes() : MutableList<Recipe> {

        val additionRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            additionRecipes.add(item)
        }
        return additionRecipes
    }

    fun getBreadRecipes() : MutableList<Recipe> {

        val breadRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            breadRecipes.add(item)
        }
        return breadRecipes
    }

    fun getCakeRecipes() : MutableList<Recipe> {

        val cakeRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            cakeRecipes.add(item)
        }
        return cakeRecipes
    }

    fun getMainDishRecipes() : MutableList<Recipe> {

        val mainDishRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            mainDishRecipes.add(item)
        }
        return mainDishRecipes
    }

    fun getSaladRecipes() : MutableList<Recipe> {

        val saladRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            saladRecipes.add(item)
        }
        return saladRecipes
    }

    fun loadRecipeData() {
        val dbInterface = context?.let { RecipeDBInterface(it) }
        if (dbInterface != null) {
            localRecipes = dbInterface.readFromDB()
        }
    }

    fun writeRecipeData() {
        val dbInterface = context?.let { RecipeDBInterface(it) }
        dbInterface?.writeToDB(localRecipes)
    }
}