package com.example.rezepte.data

import android.content.res.Resources

fun zusaetzeList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Apfelmus",
            Zutaten = "2kg Äpfel\n250ml Wasser\n2EL Zucker\n1EL Zitronensaft\nPrise Zimt",
            Beschreibung = "..."
        )
    )
}