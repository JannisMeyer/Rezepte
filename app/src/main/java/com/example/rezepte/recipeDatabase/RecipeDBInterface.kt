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
                Log.d(ContentValues.TAG, "Writing addition list...")
                for (item in recipeList) {
                    DatabaseProvider.getDatabase(context).additionDataDao().insertAdditionData(item)
                }
                dataWritingComplete = true
                Log.d(ContentValues.TAG, "Wrote addition list")
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

            recipeList = DatabaseProvider.getDatabase(context).additionDataDao().getAdditionData()
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
}
