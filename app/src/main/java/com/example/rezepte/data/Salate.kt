package com.example.rezepte.data

import android.content.res.Resources

fun salateList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Kartoffelsalat",
            Zutaten = listOf("2kg Kartoffeln", "100ml Hühnerbrühe", "2TL Salz", "3EL Essig", "1TL Pfeffer", "evtl. weiteres Gemüse"),
            Beschreibung = "..."
        )
    )
}