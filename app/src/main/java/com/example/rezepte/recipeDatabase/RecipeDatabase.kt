package com.example.rezepte.recipeDatabase

import android.content.Context
import androidx.room.*
import com.example.rezepte.data.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun additionDataDao(): AdditionDataDao
    abstract fun breadDataDao(): BreadDataDao
    abstract fun cakeDataDao(): CakeDataDao
    abstract fun mainDishDataDao(): MainDishDataDao
    abstract fun saladDataDao(): SaladDataDao
}

@Dao
interface AdditionDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdditionData(recipeEntry: Recipe)

    @Query("SELECT * FROM recipe_data WHERE type = 'addition' ORDER BY title ASC")
    suspend fun getAdditionData(): MutableList<Recipe>
}

@Dao
interface BreadDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreadData(recipeEntry: Recipe)

    @Query("SELECT * FROM recipe_data WHERE type = 'bread' ORDER BY title ASC")
    suspend fun getBreadData(): MutableList<Recipe>
}

@Dao
interface CakeDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCakeData(recipeEntry: Recipe)

    @Query("SELECT * FROM recipe_data WHERE type = 'cake' ORDER BY title ASC")
    suspend fun getCakeData(): MutableList<Recipe>
}

@Dao
interface MainDishDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMainDishData(recipeEntry: Recipe)

    @Query("SELECT * FROM recipe_data WHERE type = 'main dish' ORDER BY title ASC")
    suspend fun getMainDishData(): MutableList<Recipe>
}

@Dao
interface SaladDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSaladData(recipeEntry: Recipe)

    @Query("SELECT * FROM recipe_data WHERE type = 'salad' ORDER BY title ASC")
    suspend fun getSaladData(): MutableList<Recipe>
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