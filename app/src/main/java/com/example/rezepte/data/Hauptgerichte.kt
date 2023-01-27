package com.example.rezepte.data

import android.content.res.Resources

fun hauptgerichteList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Chicken Tikka Masala",
            Zutaten = "2 Zwiebeln\n2 Knoblauchzehen\n800g Huhn\n2EL Olivenöl\n1TL Salz\n1TL Pfeffer\n400g pürierte Dosentomaten\n250g Joghurt/200ml Sahne\n1TL Paprika\n1TL Curry\n0,5TL Chili\n0,5TL Kurkuma\n0,5TL Ingwerpulver/1cm geriebener Ingwer\nPrise Zimt",
            Beschreibung = "..."
        )
    )
}