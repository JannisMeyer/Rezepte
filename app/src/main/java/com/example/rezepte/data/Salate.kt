package com.example.rezepte.data

import android.content.res.Resources

fun salateList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Kartoffelsalat",
            Zutaten = "2kg Kartoffeln\n100ml Hühnerbrühe\n2TL Salz\n3EL Essig\n1TL Pfeffer\nevtl. weiteres Gemüse",
            Beschreibung = "..."
        )
    )
}