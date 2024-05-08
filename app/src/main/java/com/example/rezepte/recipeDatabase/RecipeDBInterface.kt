package com.example.rezepte.recipeDatabase

import android.content.ContentValues
import android.content.Context
import android.os.SystemClock
import android.util.Log
import com.example.rezepte.data.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeDBInterface(private val context: Context) {

    fun writeToDB(recipeList: List<Recipe>) {

        Log.d(ContentValues.TAG, "Writing data...")
        var dataWritingComplete = false

        CoroutineScope(Dispatchers.IO).launch {
            if (recipeList.isEmpty()) {
                Log.e(ContentValues.TAG, "Recipe list empty!")
            } else {
                Log.d(ContentValues.TAG, "Writing list...")
                for (item in recipeList) {
                    DatabaseProvider.getDatabase(context).dataDao().insertRecipe(item)
                }
                dataWritingComplete = true
                Log.d(ContentValues.TAG, "Wrote list")
            }
        }

        while (!dataWritingComplete) { // wait for coroutine to finish, function is synchronous this way
            SystemClock.sleep(100);
            Log.d(ContentValues.TAG, "dataWritingComplete: $dataWritingComplete")
        }
        Log.d(ContentValues.TAG, "Data writing complete")
    }

    fun readFromDB() : MutableList<Recipe>{

        var recipeList = mutableListOf<Recipe>()
        var dataReadingComplete = false

        CoroutineScope(Dispatchers.IO).launch {

            recipeList = DatabaseProvider.getDatabase(context).dataDao().getRecipeData()
            Log.d(ContentValues.TAG, "end db access")
            dataReadingComplete = true
            Log.d(ContentValues.TAG, "end coroutine, dataReadingComplete: $dataReadingComplete")
        }

        while (!dataReadingComplete) { // wait for coroutine to finish, function is synchronous this way
            //SystemClock.sleep(100);
            Log.d(ContentValues.TAG, "dataReadingComplete: $dataReadingComplete")
        }
        Log.d(ContentValues.TAG, "Data reading complete")
        return recipeList
    }

    fun deleteRecipeFromDB(id : Int) {

        Log.d(ContentValues.TAG, "Writing data...")
        var deletionComplete = false

        CoroutineScope(Dispatchers.IO).launch {

                Log.d(ContentValues.TAG, "Writing list...")
                DatabaseProvider.getDatabase(context).dataDao().deleteRecipeFromDB(id)
                deletionComplete = true
                Log.d(ContentValues.TAG, "Wrote list")
        }

        while (!deletionComplete) { // wait for coroutine to finish, function is synchronous this way
            SystemClock.sleep(100);
            Log.d(ContentValues.TAG, "deletionComplete: $deletionComplete")
        }
        Log.d(ContentValues.TAG, "Deletion complete")
    }
}
