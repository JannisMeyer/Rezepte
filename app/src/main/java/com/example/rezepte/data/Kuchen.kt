package com.example.rezepte.data

import android.content.res.Resources

fun kuchenList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Apfelkuchen",
            Zutaten = "6-8 Äpfel\n100g Zucker\n250g Mehl\n1 Pck. Backpulver\nPrise Salz\n1TL Zimt\n100g geschmolzene Butter\n125ml Milch\n50g Mandeln\n2EL Zucker\n2EL Wasser",
            Beschreibung = "..."
        )
    )
}