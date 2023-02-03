package com.example.rezepte.data

import android.content.res.Resources

fun zusaetzeList(resources: Resources): List<Rezept> {
    return listOf(
        Rezept(
            id = 2,
            Titel = "Apfelmus",
            Zutaten = "2kg Äpfel\n" +
                    "250ml  Wasser\n" +
                    "2EL Zucker\n" +
                    "Zitronensaft\n" +
                    "Zimt",
            Beschreibung = "Äpfel schälen und kleinschneiden, mit Wasser und Zucker aufkochen und dann ca. 25 Minuten köcheln lassen, Äpfel zerstampfen oder pürieren, mit Zitronensaft und Zimt abschmecken"
        ),
        Rezept(
            id = 3,
            Titel = "Grünes Pesto",
            Zutaten = "50g Basilikum\n" +
                    "50g Pinienkerne\n" +
                    "(3-4 Knoblauchzehen)\n" +
                    "6EL Olivenöl\n" +
                    "4EL geriebener Parmesan\n" +
                    "Prise Salz, Pfeffer",
            Beschreibung = "Alles im Mixer zerkleinern und vermischen "
        ),
        Rezept(
            id = 4,
            Titel = "Hühnchen-Marinade",
            Zutaten = "1EL Honig\n" +
                    "3EL Olivenöl\n" +
                    "2EL Sojasauce\n" +
                    "3EL Weißwein\n" +
                    "1EL Aceto Balsamico\n" +
                    "1EL Zitronensaft\n" +
                    "1TL Senf\n" +
                    "2TL Tomatenmark\n" +
                    "2 gepresste Knoblauchzehen\n" +
                    "1Zweig/1TL Rosmarin\n" +
                    "1TL Oregano\n" +
                    "0,5TL Zimt\n" +
                    "1TL Pfeffer\n" +
                    "1TL Paprikapulver",
            Beschreibung = "Alles mischen, für ca. 1kg Huhn"
        )
    )
}