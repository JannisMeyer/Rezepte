package com.example.rezepte.recipeDatabase

import android.content.Context
import androidx.room.*
import com.example.rezepte.data.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao
}

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipeEntry: Recipe)

    @Query("SELECT * FROM recipe_data WHERE type = 'addition' ORDER BY title ASC")
    suspend fun getRecipeData(): MutableList<Recipe>

    @Query("DELETE FROM recipe_data WHERE type = ':type'")
    suspend fun deleteRecipeFromDB(type : String)
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