package com.example.rezepte.data
import androidx.annotation.DrawableRes

data class Rezept (
    var id: Long,
    val Titel: String,
    val Zutaten: String,
    val Beschreibung: String
)