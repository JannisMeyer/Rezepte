package com.example.rezepte.data

import android.app.Application
import android.content.res.Resources

class Rezepte: Application() {
    companion object{
        val hauptgerichteListe:MutableList<Rezept> = mutableListOf(
            Rezept(
                id = 1,
                Titel = "Chicken Tikka Masala",
                Zutaten = "2 Zwiebeln\n" +
                        "2 Knoblauchzehen\n" +
                        "800g Hühnerbrust\n" +
                        "2EL Olivenöl\n" +
                        "1TL Salz\n" +
                        "1TL Pfeffer\n" +
                        "400g pürierte Dosentomaten\n" +
                        "250g Joghurt / 200g Schlagsahne\n" +
                        "1TL Paprikapulver\n" +
                        "1TL Currypulver\n" +
                        "0,5TL Cayennepfeffer\n" +
                        "0,5TL Kurkumapulver\n" +
                        "Messerspitze Ingwerpulver / 0,5cm Stück Ingwer\n" +
                        "Messerspitze Zimtpulver",
                Beschreibung = "Zwiebeln, Knoblauchzehen und Huhn kleinschneiden, Zwiebeln und Knoblauch im Öl anbraten, Huhn, Salz und Pfeffer dazu und braten, bis kein Rosa mehr zu sehen ist, Tomaten, Joghurt / Sahne und Gewürze dazu, mindestens 15 Minuten köcheln lassen, dazu evtl. Reis essen"
            ),
            Rezept(
                id = 3,
                Titel = "Bratreis",
                Zutaten = "2cm IngwerStück\n" +
                        "1 kleine (Frühlings-)Zwiebel\n" +
                        "1 Knoblauchzehe\n" +
                        "3EL Öl\n" +
                        "450g Gemüse (Karotten, Paprika, Erbsen etc.)\n" +
                        "250g ungekochter Reis\n" +
                        "4-5 Eier / 300g Huhn oder Lachs\n" +
                        "3EL Sojasauce\n" +
                        "Pfeffer, Chiliflocken",
                Beschreibung = "Ingwer, Zwiebel und Knoblauch kurz in Öl braten, Gemüse dazu und ca. 5 Minuten mitbraten, Reis kochen und 2 Minuten mitbraten, Reismischung an die Seite der Pfanne schieben, Eier / Fleisch durchbraten, alles vermischen und mit Sojasauce, Pfeffer und Chiliflocken abschmecken"
            ),
            Rezept(
                id = 2,
                Titel = "Flammkuchen",
                Zutaten = "200g Mehl \n" +
                        "110ml Wasser \n" +
                        "1EL ÖL\n" +
                        "1/2TL Salz\n" +
                        "100-200g Creme Fraiche o.Ä.\n" +
                        "Salz, Pfeffer, Kräuter, Essig etc.\n" +
                        "50-100g Speckwürfel\n" +
                        "1-3 Zwiebeln",
                Beschreibung = "Mehl mit Wasser, Öl und Salz zu Teig kneten und mindestens 15 Minuten abgedeckt ruhen lassen. Creme Fraiche mit Salz, Pfeffer und was man mag verrühren, Zwiebeln in Ringe schneiden, Teig auf Blech sehr dünn ausrollen und mit Creme Fraiche, Zwiebeln und Speck belegen, im vorgeheizten Ofen bei Unterhitze und maximaler Temperatur ca. 20 Minuten backen"
            ),
            Rezept(
                id = 4,
                Titel = "Kartoffelgratin",
                Zutaten = "2kg Kartoffeln\n" +
                        "2 Knoblauchzehen\n" +
                        "400ml Sahne\n" +
                        "250ml Milch\n" +
                        "1 Ei\n" +
                        "2 – 3 TL Salz\n" +
                        "200g geriebener Käse",
                Beschreibung = "Kartoffeln schälen, in Scheiben schneiden und ca. 20 Minuten kochen, Sahne, Milch,Ei, Salz,Pfeffer und Knoblauch verrühren, Kartoffeln in Auflaufform tun, Flüssigkeit rein, mit Käse bestreuen, bei 220 Grad Umluft ca. 40 Minuten backen (evtl. mit Alufolie abdecken, um Verbrennen zu vermeiden)"
            ),
            Rezept(
                id = 5,
                Titel = "Kartoffelsuppe mit Einlage",
                Zutaten = "1kg geschälte Kartoffeln\n" +
                        "4 Karotten\n" +
                        "2 Zwiebeln\n" +
                        "2EL Öl\n" +
                        "1L Gemüsebrühe\n" +
                        "1/2TL Zucker\n" +
                        "5 Wiener Würstchen\n" +
                        "50ml Sahne\n" +
                        "Petersilie, Salz, Pfeffer, Muskatnuss",
                Beschreibung = "Gemüse kleinschneiden und Zwiebeln im Öl anbraten, Kartoffeln und Karotten dazu, mit Brühe aufgießen, Zucker dazu und 25 Minuten köcheln lassen, ca.  2/3 des Gemüses rausnehmen und den Rest pürieren, Würstchen kleinschneiden und mit Sahne und Gemüse dazu, 5 Minuten warm halten, am Ende mit Salz, Pfeffer, Petersilie und Muskat abschmecken"
            ),
            Rezept(
                id = 6,
                Titel = "Kartoffelsuppe ohne Einlage",
                Zutaten = "1kg geschälte Kartoffeln\n" +
                        "4 Karotten\n" +
                        "2 Zwiebeln\n" +
                        "2EL Öl\n" +
                        "1L Gemüsebrühe\n" +
                        "1/2TL Zucker\n" +
                        "5 Wiener Würstchen\n" +
                        "50ml Sahne\n" +
                        "Petersilie, Salz, Pfeffer, Muskatnuss",
                Beschreibung = "Gemüse kleinschneiden und Zwiebeln im Öl anbraten, Kartoffeln und Karotten dazu, mit Brühe aufgießen, Zucker dazu und 25 Minuten köcheln lassen, ca.  2/3 des Gemüses rausnehmen und den Rest pürieren, Würstchen kleinschneiden und mit Sahne und Gemüse dazu, 5 Minuten warm halten, am Ende mit Salz, Pfeffer, Petersilie und Muskat abschmecken"
            ),
            Rezept(
                id = 7,
                Titel = "Kichererbsen-Curry",
                Zutaten = "2 Zwiebeln\n" +
                        "1TL Zucker\n" +
                        "50ml Olivenöl\n" +
                        "3 Knoblauchzehen\n" +
                        "5cm Stück Ingwer\n" +
                        "3TL Kreuzkümmel\n" +
                        "3TL Garam Masala\n" +
                        "3TL Kurkuma\n" +
                        "3TL Koriander" +
                        "3 Tomatendosen" +
                        "250ml Wasser" +
                        "4 Dosen Kichererbsen" +
                        "1EL Stärke" +
                        "1EL Wasser" +
                        "20g Butter" +
                        "1EL Zitronensaft" +
                        "Petersilie" +
                        "Salz, Pfeffer",
                Beschreibung = "Zwiebel mit Zucker im Öl anbraten, Knoblauch und Ingwer hacken und mit Gewürzen kurz mitbraten, Dosentomaten und Wasser dazu, 30 Minuten offen köcheln lassen, Soße pürieren, Stärke mit Wasser verrühren und einrühren, Kichererbsen, Zitronensaft, Butter und Petersilie dazu, mit Salz und Pfeffer abschmecken"
            ),
            Rezept(
                id = 8,
                Titel = "Lasagne",
                Zutaten = "800g Hackfleisch\n" +
                        "2 Zwiebeln\n" +
                        "2 Karotten\n" +
                        "3EL Olivenöl\n" +
                        "1EL Tomatenmark\n" +
                        "1TL italienische Kräuter\n" +
                        "1TL Zucker\n" +
                        "2 Dosen Tomaten\n" +
                        "2 gepressteKnoblauchzehen\n" +
                        "Salz, Pfeffer \n" +
                        "80g Butter \n" +
                        "4EL Mehl \n" +
                        "1L Milch\n" +
                        "Salz, Pfeffer, Muskatnuss\n" +
                        "50g Parmesan\n" +
                        "2 Kugeln Mozzarella\n" +
                        "bis zu 500g Nudelplatten",
                Beschreibung = "Hackfleisch mit Gemüse im Öl anbraten, Tomatenmark, Kräuter und Zucker dazu und kurz mitbraten, mit Dosentomaten ablöschen und Knoblauch dazu, köcheln lassen und mit Salz und Pfeffer abschmecken, derweil Butter in zweitem Topf schmelzen und Mehl darin anbraten, bis es gelb-braun wird, unter rühren mit Milch ablöschen, aufkochen und dabei konstant umrühren, Hitze weg und mit Salt, Pfeffer und Muskatnuss abschmecken, Parmesan reiben und Mozzarella schneiden, 25x50cm – Auflaufform einfetten, abwechselnd Ragout, Parmesan, Nudelplatten und Bechamelsauce übereinander schichten, am Ende mit Mozzarella belegen, im vorgeheizten Ofen bei 200 Grad Umluft ca. 30 Minuten backen, ca. 10 Minuten abkühlen lassen"
            ),
            Rezept(
                id = 9,
                Titel = "Linseneintopf",
                Zutaten = "1 Zwiebel\n" +
                        "3EL Olivenöl\n" +
                        "2 Karotten\n" +
                        "0,5 Lauch / Bund Frühlingszwiebeln\n" +
                        "3 mittelgroße Kartoffeln\n" +
                        "150g Linsen\n" +
                        "1L Hühnerbrühe\n" +
                        "0,25TL gemahlener Kreuzkümmel\n" +
                        "Prise Zucker\n" +
                        "3TL Weißweinessig\n" +
                        "3 Wiener Würstchen",
                Beschreibung = "Zwiebel kleinschneiden und in Öl braten, Gemüse kleinschneiden und kurz mitbraten, Linsen, Hühnerbrühe, Gewürze und Essig dazu und umrühren, ca. 30 Minuten köcheln lassen, Würstchen kleinschneiden und kurz mitkochen zum erwärmen (nicht von Anfang an rein!), mit Salz und Pfeffer abschmecken"
            ),
            Rezept(
                id = 10,
                Titel = "Linsensuppe",
                Zutaten = "2 Zwiebeln\n" +
                        "2 Knoblauchzehen\n" +
                        "3EL Olivenöl\n" +
                        "4 Tomaten \n" +
                        "250g rote Linsen \n" +
                        "1L Gemüsebrühe\n" +
                        "6 Kardamomkapseln\n" +
                        "0,5 Zimtstangen\n" +
                        "1TL gemahlener Kreuzkümmel\n" +
                        "0,5TL gemahlener Kurkuma\n" +
                        "0,5 TL gemahlener Pfeffer \n" +
                        "400ml / 1 Dose Kokosmilch\n" +
                        "1EL Zitronensaft",
                Beschreibung = "Zwiebeln und Knoblauch kleinschneiden und im Öl anbraten, Tomaten kleinschneiden und mit Linsen dazugeben, mit Brühe aufgießen und aufkochen, Gewürze dazu und ca. 25 Minuten köcheln lassen, Kardamomkapseln und Zimtstange entfernen und Suppe pürieren, Kokosmilch und Zitronensaft dazu"
            ),
            Rezept(
                id = 11,
                Titel = "Pide",
                Zutaten = "500g Weizenmehl\n" +
                        "4g Trockenhefe\n" +
                        "250ml Wasser \n" +
                        "5g Salz\n" +
                        "50g Joghurt\n" +
                        "20g Olivenöl\n" +
                        "\n" +
                        "1 Zwiebel\n" +
                        "1 Knoblauchzehe\n" +
                        "2 Stangen Lauch\n" +
                        "40g Butter / Olivenöl\n" +
                        "500g Spinat (frisch oder tiefgekühlt)\n" +
                        "500g Schafskäse\n" +
                        "Salz, Pfeffer, Muskat\n" +
                        "\n" +
                        "1 Ei, Milch",
                Beschreibung = "Mehl mit Trockenhefe mischen, Wasser leicht erwärmen und Salz, Joghurt und Öl darin auflösen, Wassermischung mit Mehlmischung zu Teig verarbeiten und 10 Minuten kneten, abgedeckt ca. 2 Stunden gehen lassen, in der Zwischenzeit Zwiebel und Knoblauch in Butter / Olivenöl anbraten, Lauch kleinschneiden und kurz mitbraten, Spinat dazu (zusammenfallen lassen, wenn frisch) und vermischen, in Sieb abtropfen und am besten ausdrücken, mit Schafskäse in separater Schüssel vermischen, mit Salz, Pfeffer und Muskat abschmecken, Teig in vier Stücke teilen und jeweils 2-3mm dünn länglich ausrollen, mit ¼ der Spinatmischung füllen,die Seiten zuklappen und die Enden zudrücken, Milch und Ei vermischen und damit Pide bestreichen (evtl. mit Sesam bestreuen), Pide bei 220 Grad Oberunterhitze im vorgeheizten Ofen ca. 20 Minuten backen"
            ),
            Rezept(
                id = 12,
                Titel = "Sheperds Pie",
                Zutaten = "800g Kartoffeln\n" +
                        "40g Butter \n" +
                        "250ml Milch\n" +
                        "Salz, Pfeffer, Muskat \n" +
                        "800g Hackfleisch\n" +
                        "2 Zwiebeln\n" +
                        "2 Karotten\n" +
                        "2EL Tomatenmark\n" +
                        "2 Knoblauchzehen\n" +
                        "1TL getrocknete Kräuter\n" +
                        "etwas Wasser \n" +
                        "150g Erbsen\n" +
                        "100g Käse der Wahl",
                Beschreibung = "Kartoffeln schälen und kochen, Butter und Milch dazu zerstampfen, mit Salz, Pfeffer und Muskat abschmecken, Hackfleisch mit Zwiebeln und Karotten anbraten, Tomatenmark, Knoblauch und Kräuter dazu und kurz mitbraten, Wasser und Erbsen dazu, köcheln lassen und mit Salz und Pfeffer abschmecken, Auflaufform einfetten und mit Ragout befüllen, Kartoffelbrei obendrauf verteilen und glattstreichen, Käse reiben und verteilen, im vorgeheizten Ofen bei 200 Grad Umluft ca. 30 Minuten backen oder bis der Käse braun ist, 10 Minuten abkühlen lassen"
            ),
            Rezept(
                id = 13,
                Titel = "Thunfisch-Nudeln",
                Zutaten = "150-200g Nudeln\n" +
                        "1-2 Zwiebeln \n" +
                        "2EL Öl\n" +
                        "½  Dose Thunfisch \n" +
                        "1/2TL Tomatenmark\n" +
                        "100ml Milch o.Ä.\n" +
                        "Kräuter\n" +
                        "Essig, Zitronensaft, Tabasco etc.\n" +
                        "Salz, Pfeffer",
                Beschreibung = "Nudeln kochen(bisschen Nudelwasser aufbewahren!), derweil Zwiebeln im Öl anbraten, Thunfisch und Tomatenmark dazu und kurz mitbraten, bis Thunfischgeruch weg ist, mit Milch ablöschen und Hitze weg, Kräuter, Nudeln und Nudelwasser dazu und alles cremig rühren, mit Essig, Salz und Pfeffer abschmecken"
            )
        )
    }
}
