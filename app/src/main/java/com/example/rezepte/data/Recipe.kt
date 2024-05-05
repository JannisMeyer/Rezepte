package com.example.rezepte.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_data")
class Recipe (
    @PrimaryKey(autoGenerate = true)var id: Int = 0,
    var type: String,
    var title: String,
    var ingredients: String,
    var description: String
)