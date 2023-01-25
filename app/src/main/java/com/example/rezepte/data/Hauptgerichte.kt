package com.example.rezepte.data

import android.content.res.Resources

fun hauptgerichteList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Chicken Tikka Masala",
            Zutaten = listOf("2 Zwiebeln", "2 Knoblauchzehen", "800g Huhn", "2EL Olivenöl", "1TL Salz", "1TL Pfeffer", "400g pürierte Dosentomaten", "250g Joghurt/200ml Sahne", "1TL Paprika", "1TL Curry", "0,5TL Chili", "0,5TL Kurkuma", "0,5TL Ingwerpulver/1cm geriebener Ingwer", "Prise Zimt"),
            Beschreibung = "..."
        )
    )
}