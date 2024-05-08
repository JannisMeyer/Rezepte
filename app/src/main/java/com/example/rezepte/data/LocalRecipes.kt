package com.example.rezepte.data

import android.content.Context
import com.example.rezepte.recipeDatabase.RecipeDBInterface

class LocalRecipes {

    companion object {
        @Volatile
        private var instance : LocalRecipes? = null

        fun getInstance(contextParam : Context): LocalRecipes? {

            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = LocalRecipes()
                    }
                }
            }
            return instance
        }
    }

    var localRecipes = mutableListOf<Recipe>()

    fun getAdditionRecipes() : MutableList<Recipe> {

        val additionRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            if (item.type == "addition") {
                additionRecipes.add(item)
            }
        }
        return additionRecipes
    }

    fun getBreadRecipes() : MutableList<Recipe> {

        val breadRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            if (item.type == "addition") {
                breadRecipes.add(item)
            }
        }
        return breadRecipes
    }

    fun getCakeRecipes() : MutableList<Recipe> {

        val cakeRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            if (item.type == "addition") {
                cakeRecipes.add(item)
            }
        }
        return cakeRecipes
    }

    fun getMainDishRecipes() : MutableList<Recipe> {

        val mainDishRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            if (item.type == "addition") {
                mainDishRecipes.add(item)
            }
        }
        return mainDishRecipes
    }

    fun getSaladRecipes() : MutableList<Recipe> {

        val saladRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            if (item.type == "addition") {
                saladRecipes.add(item)
            }
        }
        return saladRecipes
    }

    fun loadAllRecipeData(context : Context) {
        val dbInterface = RecipeDBInterface(context)
        localRecipes = dbInterface.readFromDB()
    }

    fun writeAllRecipeData(context : Context) {
        val dbInterface = RecipeDBInterface(context)
        dbInterface.writeToDB(localRecipes)
    }

    fun writeRecipe(recipe : Recipe, context: Context) {
        val dbInterface = RecipeDBInterface(context)
        dbInterface.writeToDB(listOf(recipe))
    }

    fun deleteRecipe(id: Int, context: Context) {
        val dbInterface = RecipeDBInterface(context)
        dbInterface.deleteRecipeFromDB(id)
    }
}