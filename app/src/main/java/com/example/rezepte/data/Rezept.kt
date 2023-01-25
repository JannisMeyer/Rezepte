package com.example.rezepte.data
import androidx.annotation.DrawableRes

data class Rezept (
    val id: Long,
    val Titel: String,
    val Zutaten: List<String>,
    val Beschreibung: String
)