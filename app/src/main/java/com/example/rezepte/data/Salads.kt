package com.example.rezepte.data

import android.app.Application

class Salads: Application() {
    companion object {
        var saladList: MutableList<Recipe> = mutableListOf(
            Recipe(
                id = 1,
                title = "Kartoffelsalat",
                ingredients = "2kg Kartoffeln\n100ml Hühnerbrühe\n2TL Salz\n3EL Essig\n1TL Pfeffer\nevtl. weiteres Gemüse",
                description = "Kartoffeln schälen und kochen, kleinschneiden und mit allen Zutaten gut verrühren, (Gemüse unterheben), abkühlen und durchziehen lassen"
            ),
            Recipe(
                id = 2,
                title = "Tabouleh-Salat",
                ingredients = "150g Bulgur/Couscous\n" +
                        "4 Tomaten \n" +
                        "1 Gurke\n" +
                        "viel Petersilie\n" +
                        "bisschen Minze\n" +
                        "evtl. Frühlingszwiebeln/Granatapfel\n" +
                        "2EL Zitronensaft\n" +
                        "7EL Olivenöl",
                description = "Bulgur/Couscous zubereiten, Gemüse und Kräuter schneiden, alles mischen"
            ),
            Recipe(
                id = 3,
                title = "Tomaten-Salat",
                ingredients = "1kg Tomaten\n" +
                        "3 Frühlingszwiebeln\n" +
                        "Basilikum\n" +
                        "1,5EL Aceto Balsamico\n" +
                        "4EL Olivenöl",
                description = "Tomaten,Frühlingszwiebeln und Basilikum kleinschneiden (Zwiebeln evtl. blanchieren), alles mischen"
            )
        )
    }
}