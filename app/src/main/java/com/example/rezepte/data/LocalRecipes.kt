package com.example.rezepte.data

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.rezepte.recipeDatabase.RecipeDBInterface

class LocalRecipes {

    companion object {
        @Volatile
        private var instance : LocalRecipes? = null

        fun getInstance(): LocalRecipes? {

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
            if (item.type == "bread") {
                breadRecipes.add(item)
            }
        }
        return breadRecipes
    }

    fun getCakeRecipes() : MutableList<Recipe> {

        val cakeRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            if (item.type == "cake") {
                cakeRecipes.add(item)
            }
        }
        return cakeRecipes
    }

    fun getMainDishRecipes() : MutableList<Recipe> {

        val mainDishRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            if (item.type == "mainDish") {
                //Log.d(ContentValues.TAG, "main dish: "+item.title)
                mainDishRecipes.add(item)
            }
        }
        return mainDishRecipes
    }

    fun getSaladRecipes() : MutableList<Recipe> {

        val saladRecipes = mutableListOf<Recipe>()
        for (item in localRecipes) {
            if (item.type == "salad") {
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
        for (item in localRecipes) {
            Log.d(ContentValues.TAG, "local recipe: "+item.title)
        }
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

    fun findId() : Int {
        var id = 1
        for (item in localRecipes) {
            if (item.id == id) {
                id++
            } else {
                break
            }
        }
        return id
    }
}