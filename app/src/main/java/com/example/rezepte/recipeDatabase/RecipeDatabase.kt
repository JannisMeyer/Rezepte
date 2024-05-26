package com.example.rezepte.recipeDatabase

import android.content.ClipDescription
import android.content.ContentValues
import android.content.Context
import android.util.Log
import androidx.room.*
import com.example.rezepte.data.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao
}

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipeEntry: Recipe) : Long

    @Query("SELECT * FROM recipe_data ORDER BY type ASC, title ASC")
    suspend fun getRecipeData(): MutableList<Recipe>

    @Query("SELECT * FROM recipe_data WHERE type = 'main dish' ORDER BY title ASC")
    suspend fun getMainDishesTest(): MutableList<Recipe>

    @Query("DELETE FROM recipe_data WHERE id = :id")
    suspend fun deleteRecipeFromDB(id : Int)

    @Query("DELETE FROM recipe_data")
    suspend fun clearDB()

    @Query("UPDATE recipe_data SET title = :title, ingredients = :ingredients, description = :description WHERE id = :id")
    suspend fun updateRecipeFromDB(id : Int, title : String, ingredients : String, description : String)
}

object DatabaseProvider {
    private var instance: RecipeDatabase? = null

    fun getDatabase(context: Context): RecipeDatabase {
        return instance ?: synchronized(this) {
            val db = Room.databaseBuilder(
                context.applicationContext,
                RecipeDatabase::class.java,
                "recipe_database"
            ).build()
            instance = db
            db
        }
    }
}