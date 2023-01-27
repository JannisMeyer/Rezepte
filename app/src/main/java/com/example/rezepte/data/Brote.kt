package com.example.rezepte.data

import android.content.res.Resources

fun broteList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Baguette",
            Zutaten = "540ml Wasser\n3TL Salz\n1/2 Pck. Frischhefe/1 Pck. Trockenhefe\n800g Mehl",
            Beschreibung = "..."
        )
    )
}