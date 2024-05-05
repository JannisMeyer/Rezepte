package com.example.rezepte.recipeDatabase

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.rezepte.data.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeDBInterface(private val context: Context) {

    fun writeToDB(recipeList: List<Recipe>, recipeType : String) {

        var dataWritingComplete = false

        CoroutineScope(Dispatchers.IO).launch {
            if (recipeList.isEmpty()) {
                Log.e(ContentValues.TAG, "Recipe list empty!")
            } else {
                when (recipeType) {
                    "addition" -> {
                        Log.d(ContentValues.TAG, "Writing addition list...")
                        for (item in recipeList) {
                            DatabaseProvider.getDatabase(context).additionDataDao().insertAdditionData(item)
                        }
                        dataWritingComplete = true
                        Log.d(ContentValues.TAG, "Wrote addition list")
                    }
                    "bread" -> {
                        Log.d(ContentValues.TAG, "Writing bread list...")
                        for (item in recipeList) {
                            DatabaseProvider.getDatabase(context).breadDataDao().insertBreadData(item)
                        }
                        dataWritingComplete = true
                        Log.d(ContentValues.TAG, "Wrote bread list")
                    }
                    "cake" -> {
                        Log.d(ContentValues.TAG, "Writing cake list...")
                        for (item in recipeList) {
                            DatabaseProvider.getDatabase(context).cakeDataDao().insertCakeData(item)
                        }
                        dataWritingComplete = true
                        Log.d(ContentValues.TAG, "Wrote cake list")
                    }
                    "main dish" -> {
                        Log.d(ContentValues.TAG, "Writing main dish list...")
                        for (item in recipeList) {
                            DatabaseProvider.getDatabase(context).mainDishDataDao().insertMainDishData(item)
                        }
                        dataWritingComplete = true
                        Log.d(ContentValues.TAG, "Wrote main dish list")
                    }
                    "salad" -> {
                        Log.d(ContentValues.TAG, "Writing salad list...")
                        for (item in recipeList) {
                            DatabaseProvider.getDatabase(context).saladDataDao().insertSaladData(item)
                        }
                        dataWritingComplete = true
                        Log.d(ContentValues.TAG, "Wrote salad list")
                    }
                    else -> {
                        Log.e(ContentValues.TAG, "Invalid recipe type!")
                    }
                }
            }
        }

        while (!dataWritingComplete) { // wait for coroutine to finish, function is synchronous this way
            ;
        }
        Log.d(ContentValues.TAG, "Data writing complete")
    }

    fun readFromDB(recipeType : String) : List<Recipe>{

        var recipeList = emptyList<Recipe>()
        var dataReadingComplete = false

        CoroutineScope(Dispatchers.IO).launch {

            when (recipeType) {
                "addition" -> {
                    recipeList = DatabaseProvider.getDatabase(context).additionDataDao().getAdditionData()
                    dataReadingComplete = true
                }
                "bread" -> {
                    recipeList = DatabaseProvider.getDatabase(context).breadDataDao().getBreadData()
                    dataReadingComplete = true
                }
                "cake" -> {
                    recipeList = DatabaseProvider.getDatabase(context).cakeDataDao().getCakeData()
                    dataReadingComplete = true
                }
                "main dish" -> {
                    recipeList = DatabaseProvider.getDatabase(context).mainDishDataDao().getMainDishData()
                    dataReadingComplete = true
                }
                "salad" -> {
                    recipeList = DatabaseProvider.getDatabase(context).saladDataDao().getSaladData()
                    dataReadingComplete = true
                }
                else -> {
                    Log.e(ContentValues.TAG, "Invalid recipe type!")
                }
            }
        }

        while (!dataReadingComplete) { // wait for coroutine to finish, function is synchronous this way
            ;
        }
        Log.d(ContentValues.TAG, "Data reading complete")
        return recipeList
    }
}
