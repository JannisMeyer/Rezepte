package com.example.rezepte.data

import android.app.Application

class Breads: Application() {
    companion object{
        var breadList:MutableList<Recipe> = mutableListOf(
            Recipe(
                id = 1,
                title = "Baguette",
                ingredients = "540ml lauwarmes Wasser\n" +
                        "3TL Salz\n" +
                        "2 Prisen Zucker\n" +
                        "0,5 Würfel Frischhefe (oder 1 Päckchen Trockenhefe)\n" +
                        "800g helles Weizenmehl",
                description = "Wasser erwärmen und mit Hefe, Salz und Zucker verrühren, Flüssigkeit mit Mehl mischen und durchkneten, Teig 2,5 Stunden gehen lassen, Teig mit viel Mehl zu 2 Broten formen (nicht nochmal kneten!), Bei 210 Grad Umluft ca. 30 Minuten backen (dabei Gefäß mit Wasser in den Ofen stellen), kurz abkühlen lassen"
            ),
            Recipe(
                id = 2,
                title = "Kastenbrot",
                ingredients = "500g Mehl (alles außer Weißmehl, evtl. Mischungen)\n" +
                        "130g Kerne\n" +
                        "500ml lauwarmes Wasser\n" +
                        "1 Würfel Frischhefe / 14g Trockenhefe\n" +
                        "2TL Salz\n" +
                        "Prise Zucker\n" +
                        "2EL Weißweinessig",
                description = "Mehl mit Kernen/Nüssen vermischen, Wasser mit Hefe, Salz, Zucker und Essig vermischen, alles zu Teig verarbeiten, Kastenform fetten und mit Paniermehl bestreuen, Teig einfüllen und evtl. mit Kernen bestreuen, Brot bei 200 Grad Ober/-Unterhitze 1 Stunde backen (Brot in den kalten Ofen stellen, nicht vorheizen!), mindestens 30 Minuten auskühlen lassen"
            ),
            Recipe(
                id = 3,
                title = "Pizzateig",
                ingredients = "550g Mehl \n" +
                        "2TL Salz\n" +
                        "3g (ein bisschen) Hefe\n" +
                        "350ml lauwarmes Wasser ",
                description = "Mehl mit Salz und Hefe vermischen, mit Wasser zu Teig kneten, mit Olivenöl einreiben, mindestens 2 Stunden gehen lassen"
            )
        )
    }
}