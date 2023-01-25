package com.example.rezepte.data

import android.content.res.Resources

fun kuchenList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Apfelkuchen",
            Zutaten = listOf("6-8 Äpfel", "100g Zucker", "250g Mehl", "1 Pck. Backpulver", "Prise Salz", "1TL Zimt", "100g geschmolzene Butter", "125ml Milch", "50g Mandeln", "2EL Zucker", "2EL Wasser"),
            Beschreibung = "..."
        )
    )
}