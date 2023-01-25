package com.example.rezepte.data

import android.content.res.Resources

fun zusaetzeList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Apfelmus",
            Zutaten = listOf("2kg Äpfel", "250ml Wasser", "2EL Zucker", "1EL Zitronensaft", "Prise Zimt"),
            Beschreibung = "..."
        )
    )
}