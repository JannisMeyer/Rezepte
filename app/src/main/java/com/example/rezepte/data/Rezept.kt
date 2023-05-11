package com.example.rezepte.data
import androidx.annotation.DrawableRes

data class Rezept (
    var id: Int,
    val Titel: String,
    val Zutaten: String,
    val Beschreibung: String
)