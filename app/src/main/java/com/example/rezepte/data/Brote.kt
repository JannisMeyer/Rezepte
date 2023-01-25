package com.example.rezepte.data

import android.content.res.Resources

fun broteList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Baguette",
            Zutaten = listOf("540ml Wasser", "3TL Salz", "1/2 Pck. Frischhefe/1 Pck. Trockenhefe", "800g Mehl"),
            Beschreibung = "..."
        )
    )
}