package com.example.rezepte.data

import android.content.res.Resources

fun salateList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 1,
            Titel = "Kartoffelsalat",
            Zutaten = "2kg Kartoffeln\n100ml Hühnerbrühe\n2TL Salz\n3EL Essig\n1TL Pfeffer\nevtl. weiteres Gemüse",
            Beschreibung = "Kartoffeln schälen und kochen, kleinschneiden und mit allen Zutaten gut verrühren, (Gemüse unterheben), abkühlen und durchziehen lassen"
        ),
        Rezept(
            id = 2,
            Titel = "Tabouleh-Salat",
            Zutaten = "150g Bulgur/Couscous\n" +
                    "4 Tomaten \n" +
                    "1 Gurke\n" +
                    "viel Petersilie\n" +
                    "bisschen Minze\n" +
                    "evtl. Frühlingszwiebeln/Granatapfel\n" +
                    "2EL Zitronensaft\n" +
                    "7EL Olivenöl",
            Beschreibung = "Bulgur/Couscous zubereiten, Gemüse und Kräuter schneiden, alles mischen"
        ),
        Rezept(
            id = 3,
            Titel = "Tomaten-Salat",
            Zutaten = "1kg Tomaten\n" +
                    "3 Frühlingszwiebeln\n" +
                    "Basilikum\n" +
                    "1,5EL Aceto Balsamico\n" +
                    "4EL Olivenöl",
            Beschreibung = "Tomaten,Frühlingszwiebeln und Basilikum kleinschneiden (Zwiebeln evtl. blanchieren), alles mischen"
        ),
    )
}