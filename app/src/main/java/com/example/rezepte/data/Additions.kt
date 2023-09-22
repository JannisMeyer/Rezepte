package com.example.rezepte.data

import android.app.Application

class Additions: Application() {
    companion object {
        var additionsList: MutableList<Recipe> = mutableListOf(
            Recipe(
                id = 2,
                title = "Apfelmus",
                ingredients = "2kg Äpfel\n" +
                        "250ml  Wasser\n" +
                        "2EL Zucker\n" +
                        "Zitronensaft\n" +
                        "Zimt",
                description = "Äpfel schälen und kleinschneiden, mit Wasser und Zucker aufkochen und dann ca. 25 Minuten köcheln lassen, Äpfel zerstampfen oder pürieren, mit Zitronensaft und Zimt abschmecken"
            ),
            Recipe(
                id = 3,
                title = "Grünes Pesto",
                ingredients = "50g Basilikum\n" +
                        "50g Pinienkerne\n" +
                        "(3-4 Knoblauchzehen)\n" +
                        "6EL Olivenöl\n" +
                        "4EL geriebener Parmesan\n" +
                        "Prise Salz, Pfeffer",
                description = "Alles im Mixer zerkleinern und vermischen "
            ),
            Recipe(
                id = 4,
                title = "Hühnchen-Marinade",
                ingredients = "1EL Honig\n" +
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
                description = "Alles mischen, für ca. 1kg Huhn"
            ),
            Recipe(
                id = 5,
                title = "Reis",
                ingredients = "1,75 Teile Wasser (Gewicht)\n" +
                        "Salz\n" +
                        "1 Teil Reis (Gewicht)",
                description = "Wasser mit Salz aufkochen, Reis dazu und einmal umrühren, Deckel drauf und bei niedriger Hitze (Stufe 4 von 9) ca. 25 Minuten köcheln lassen, mit Gabel umrühren, kurz abdampfen lassen"
            )
        )
    }
}