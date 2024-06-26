package com.example.rezepte.data

import android.app.Application

class Cakes: Application() {
    companion object {
        var cakeList: MutableList<Recipe> = mutableListOf(
            Recipe(
                id = 1,
                title = "Apfelkuchen",
                type = "cake",
                ingredients = "6 – 8 Äpfel\n" +
                        "100g Zucker \n" +
                        "2 Eier\n" +
                        "250g Mehl \n" +
                        "1 Pck. Backpulver\n" +
                        "Prise Salz\n" +
                        "1TL Zimt (optional)\n" +
                        "100g geschmolzene Butter \n" +
                        "125ml Milch\n" +
                        "50g Mandeln \n" +
                        "2EL Zucker \n" +
                        "1El Wasser ",
                description = "Äpfel schälen und vierteln, Zucker mit Eiern cremig rühren, in zweiter Schüssel Mehl, Backpulver, Salz und Zimt vermischen, Mehlmischung, Butter und Milch mit Eimischung verrühren, in Springform geben, Äpfel in Kreisen in Teig drücken, Mandeln klein hacken, mit Zucker und Wasser vermischen und auf Äpfeln verteilen, im vorgeheizten Ofen bei 180 Grad Umluft ca. 45 Minuten backen"
            ),
            Recipe(
                id = 2,
                title = "Beerentorte",
                type = "cake",
                ingredients = "6 Eier\n" +
                        "Prise Salz\n" +
                        "150g Zucker\n" +
                        "160g Mehl\n" +
                        "1TL Backpulver\n" +
                        "\n" +
                        "6 Blatt Gelatine\n" +
                        "400g Beeren\n" +
                        "1 Päckchen Zitronenschale\n" +
                        "2EL Zitronensaft\n" +
                        "150g Zucker\n" +
                        "500g Magerquark\n" +
                        "400g Schlagsahne",
                description = "Eier trennen und Eiweiß mit Salz steif schlagen, Eigelbe mit Zucker schaumig schlagen, Mehl und Backpulver mischen, Eiweiß und Mehlmischung unter Eigelb rühren, Teig in Springform füllen und im vorgeheizten Ofen bei 160 Grad Umluft ca. 25 Minuten backen, abkühlen lassen, für die Creme Gelatine in Wasser einweichen und Beeren pürieren, Beerenpüree, Zitronensaft-und Schale, Zucker und Quark verrühren, Gelatine (ohne Wasser) im Topf auflösen und 2EL der Beerenmischung unterrühren, Gelatinemischung in Beerenmischung geben und verrühren, Creme kaltstellen, sobald diese geliert, Sahne steif schlagen und unterheben, Kuchen horizontal halbieren und die Hälfte der Creme draufstreichen (mit Springform drumherum), andere Hälfte auf den Deckel, evtl. dekorieren und vollständig abkühlen bzw. fest werden lassen"
            ),
            Recipe(
                id = 3,
                title = "Browneys",
                type = "cake",
                ingredients = "300g Zartbitterschokolade\n" +
                        "200g Apfelmus / 200ml neutrales Öl\n" +
                        "2 Päckchen Vanillezucker\n" +
                        "6 Eier\n" +
                        "100g brauner Zucker\n" +
                        "300g Mehl \n" +
                        "2TL Backpulver\n" +
                        "1 Prise Salz\n" +
                        "2EL Kakaopulver\n" +
                        "100g Schokostreusel",
                description = "Zartbitterschokolade schmelzen, Apfelmus / Öl, Vanillezucker, Eier und braunen Zucker schaumig rühren, Mehl, Backpulver, Salz, Kakaopulver und Schokostreusel mischen, Mehlmischung mit Eimischung und geschmolzener Schokolade verrühren, im vorgeheizten Ofen bei 155 Grad Umluft ca. 20 Minuten backen"
            ),
            Recipe(
                id = 4,
                title = "Cookies",
                type = "cake",
                ingredients = "150g (brauner) Zucker\n" +
                        "1 Päckchen Vanillezucker\n" +
                        "200g weiche Butter / 160ml neutrales Öl\n" +
                        "2 Eier\n" +
                        "300g Mehl \n" +
                        "0,5 Päckchen Backpulver\n" +
                        "Prise Salz\n" +
                        "100g Schokotropfen etc.\n" +
                        "4EL Milch",
                description = "Zucker, Vanillezucker und Butter / Öl schaumig rühren, Eier nach und nach dazu, in separater Schüssel Mehl, Backpulver, Salz und Schokotropfen vermischen, Eimischung mit Mehlmischung und Milch verrühren, Cookies auf Blech verteilen (max. 12 pro Blech) und im vorgeheizten Backofen bei 160 Grad Umluft / 180 Grad Oberunterhizte 15 – 20 Minuten backen"
            ),
            Recipe(
                id = 5,
                title = "Donauwellen-Gugelhupf",
                type = "cake",
                ingredients = "300g weiche Butter \n" +
                        "1 Päckchen Vanillezucker\n" +
                        "250g Zucker\n" +
                        "6 Eier\n" +
                        "300g Mehl\n" +
                        "2Tl Backpulver\n" +
                        "3EL Kakaopulver\n" +
                        "2EL Milch\n" +
                        "500g Kirschen\n" +
                        "\n" +
                        "150g Zartbitterschokolade\n" +
                        "150g Schlagsahne\n" +
                        "15g Kokosfett",
                description = "Butter, Vanillezucker und Zucker cremig rühren, Eier nacheinander einrühren, Mehl und Backpulver mischen und unterrühren, Teig halbieren, in eine Hälfte Kakaopulver und Milch rühren, Hälfte des hellen Teigs in Gugelhupfform geben, Hälfte des dunklen Teigs drauf, Hälfte der Kirschen drauf, Hälfte des hellen Teigs drauf, Hälfte der Kirschen drauf, Hälfte des dunklen Teigs drauf, im vorgeheizten Ofen bei 150 Grad Umluft ca. 1 Stunde backen, abkühlen lassen, für die Glasur Schokolade schmelzen, Sahne und Kokosfett einrühren, über Kuchen geben, auskühlen lassen"
            ),
            Recipe(
                id = 6,
                title = "Eierlikörkuchen",
                type = "cake",
                ingredients = "190g Zucker \n" +
                        "1 Pck. Vanillezucker\n" +
                        "4 Eier\n" +
                        "250g Mehl\n" +
                        "1 Pck. Backpulver\n" +
                        "Prise Salz\n" +
                        "200ml neutrales Öl / 200g geschmolzene Butter \n" +
                        "250ml Eierlikör",
                description = "Zucker, Vanillezucker und Eier cremig rühren, Mehl, Backpulver und Salz in zweiter Schüssel vermischen, Mehlmischung, Öl / Butter und Eierlikör mit Eimischung verrühren, im vorgeheizten Ofen bei 180 Grad Umluft ca. 50 Minuten backen (am besten in Guglhupfform)"
            ),
            Recipe(
                id = 7,
                title = "Knusprige Haferkekse",
                type = "cake",
                ingredients = "120g Haferflocken\n" +
                        "100g Zucker\n" +
                        "2 Eier\n" +
                        "2EL Mehl \n" +
                        "2TL Backpulver\n" +
                        "Prise Salz\n" +
                        "Zimt",
                description = "Alles verrühren und teelöffelgroße Haufen auf Backblech verteilen (Optimum 9 pro Blech), bei 205 Grad Umluft ca. 10 Minuten backen, auskühlen lassen"
            ),
            Recipe(
                id = 8,
                title = "Weiche Haferkekse",
                type = "cake",
                ingredients = "200g Haferflocken\n" +
                        "120g Mehl\n" +
                        "100g Zucker \n" +
                        "Prise Salz\n" +
                        "1TL Natron\n" +
                        "1EL Ahornsirup\n" +
                        "2E Wasser \n" +
                        "115g geschmolzene Butter ",
                description = "Haferflocken, Mehl, Zucker und Salz vermischen, Natron mit Wasser und Ahornsirup aufkochen und zu Mehlmischung geben, Butter dazu und verrühren, aus Masse ein ca. 1cm dickes Rechteck auf Backpapier formen, im vorgeheizten Ofen bei 175 Grad Umluft ca. 15 Minuten backen, oder bis der Teig gold-gelb ist, rausnehmen und in Stücke schneiden, vollständig auskühlen lassen"
            ),
            Recipe(
                id = 9,
                title = "Heidelbeer-Muffins",
                type = "cake",
                ingredients = "200g Mehl\n" +
                        "60g feine Haferflocken\n" +
                        "2TL Backpulver\n" +
                        "0,5TL Natron\n" +
                        "200g Heidelbeeren\n" +
                        "2 Eier\n" +
                        "150g brauner Zucker\n" +
                        "1 Päckchen Vanillezucker\n" +
                        "1 Prise Salz\n" +
                        "150g weiche Butter\n" +
                        "300g saure Sahne/Joghurt",
                description = "Mehl mit Haferflocken, Backpulver und Natron vermischen, Eier mit Zucker, Vanillezucker und Salz schaumig rühren, saure Sahne/Joghurt und Mehlmischung unterrühren, Heidelbeeren unterheben, Teig in Muffin-Formen füllen und im vorgeheizten Ofen bei 160 Grad Umluft ca. 25 Minuten backen"
            ),
            Recipe(
                id = 10,
                title = "Himbeer-Streusel-Käsekuchen",
                type = "cake",
                ingredients = "200g weiche Butter \n" +
                        "100g Zucker\n" +
                        "350g Mehl \n" +
                        "1 Prise Salz\n" +
                        "\n" +
                        "1kg Magerquark\n" +
                        "150g Zucker\n" +
                        "1 Päckchen Vanillezucker\n" +
                        "1 Prise Salz\n" +
                        "5 Eier\n" +
                        "1 Päckchen Vanille-Puddingpulver\n" +
                        "250g Himbeeren\n" +
                        "\n" +
                        "30g Kokosraspeln\n" +
                        "1EL Wasser\n" +
                        "1EL Kakaopulver\n" +
                        "1EL Milch",
                description = "Butter, Zucker, Mehl und Salz zu Mürbeteig verarbeiten, kaltstellen, Quark, Zucker, Vanillezucker und Salz verrühren, Eier nacheinander einrühren, Puddingpulver unterrühren, Himbeeren unterheben, Mürbeteig halbieren, eine Hälfte als Boden in Springform geben, andere Hälfte nochmal teilen und jeweils Kokosraspeln und Wasser bzw. Kakaopulver und Milch reinkneten, Quarkmischung auf Boden geben und beide Mürbeteig-Arten draufstreuseln, im vorgeheizten Ofen bei 150 Grad Umluft ca. 50 Minuten backen, auskühlen lassen"
            ),
            Recipe(
                id = 11,
                title = "Karottenkuchen",
                type = "cake",
                ingredients = "225g Mehl \n" +
                        "1/2TL Backpulver\n" +
                        "1TL Natron\n" +
                        "Prise Salz\n" +
                        "1/2TL Zimt \n" +
                        "190g Zucker \n" +
                        "1 Pck. Vanillezucker\n" +
                        "4 Eier\n" +
                        "150ml Öl / 190g Butter \n" +
                        "180g geschälte, geriebene Karotten\n" +
                        "125g Frischkäse\n" +
                        "60g Puderzucker\n" +
                        "Schuss Zitronensaft",
                description = "Mehl mit Backpulver, Natron, Salz und Zimt vermischen, in anderer Schüssel Zucker, Vanillezucker und Eier schlagen, Öl, Mehlmischung und Karotten dazu und kurz verrühren, im vorgeheizten Ofen bei 175 Grad Umluft ca. 40 Minuten backen, abkühlen lassen, Frischkäse mit Puderzucker und Zitronensaft schlagen, auf Kuchen verteilen, nochmal ruhen lassen"
            ),
            Recipe(
                id = 12,
                title = "Kartoffelkuchen",
                type = "cake",
                ingredients = "400g gekochte Kartoffeln\n" +
                        "200g Zucker \n" +
                        "4 Eier\n" +
                        "2 EL Grieß / Mehl \n" +
                        "200g gemahlene Mandeln / Haselnüsse\n" +
                        "1 Pck. Backpulver\n" +
                        "Prise Salz\n" +
                        "1 Flasche Mandelaroma (optional)\n" +
                        "200g Schokolade",
                description = "Kartoffeln zerstampfen, Zucker mit Eiern cremig rühren, Grieß / Mehl, Nüsse, Backpulver und Salz in zweiter Schüssel vermischen, Mehlmischung und Aroma mit Eimischung verrühren, im vorgeheizten Ofen bei 170 Grad Umluft ca. 50 Minuten backen (am besten auf einem Blech), auskühlen lassen, derweil Schokolade schmelzen und Kuchen dann damit überziehen, vollständig abkühlen lassen"
            ),
            Recipe(
                id = 13,
                title = "Käse-Kirsch-Kuchen",
                type = "cake",
                ingredients = "150g weiche Butter\n" +
                        "1 Päckchen Vanillezucker\n" +
                        "200g Zucker\n" +
                        "1EL Zitronensaft \n" +
                        "4EL Grieß\n" +
                        "1kg Magerquark\n" +
                        "1 Päckchen Vanille-Puddingpulver\n" +
                        "4 Eier\n" +
                        "500g Kirschen",
                description = "Butter, Vanillezucker, Zucker, Zitronensaft und Grieß verrühren, Quark und Puddingpulver einrühren, Eier nacheinander unterrühren, Kirschen unterheben, Teig in Springform füllen und im vorgeheizten Ofen bei 160 Grad Umluft ca. 1 Stunde backen, auskühlen lassen"
            ),
            Recipe(
                id = 14,
                title = "Marmorkuchen",
                type = "cake",
                ingredients = "150g Zucker\n" +
                        "175g Butter/ 140 ml neutrales Öl\n" +
                        "Vanillearoma\n" +
                        "3 Eier\n" +
                        "225g Mehl\n" +
                        "2,5TL Backpulver\n" +
                        "1 Prise Salz\n" +
                        "50g Zartbitterschokolade/ 2EL Kakao + 1EL Milch",
                description = "Zucker mit Butter/Öl und Vanillearoma verrühren, Eier einzeln unterrühren, Mehl mit Backpulver und Salz vermischen, Mehlmischung einrühren, Teig halbieren, eine Hälfte mit geschmolzener Schokolade/Kakao und Milch verrühren, Teig übereinander schichten, bei 170 Grad Umluft ca. 30 Minuten backen"
            ),
            Recipe(
                id = 15,
                title = "Pancakes",
                type = "cake",
                ingredients = "4 Eier\n" +
                        "Prise Salz\n" +
                        "2 Päckchen Vanillezucker\n" +
                        "300ml Milch\n" +
                        "300g Mehl \n" +
                        "1 Päckchen Backpulver",
                description = "Eier trennen, Eiweiß mit Salz steif schlagen, Eigelbe mit Vanillezucker und Milch schaumig rühren, in neuer Schüssel Mehl und Backpulver vermischen, Mehlmischung und Eiweiß unter Eigelbmischung heben, Pancakes in Pfanne ausbacken"
            ),
            Recipe(
                id = 16,
                title = "Rosinenbrot",
                type = "cake",
                ingredients = "600g Mehl \n" +
                        "1 Würfel Frischhefe / 14g Trockenhefe\n" +
                        "250ml Milch\n" +
                        "120g Butter\n" +
                        "70g Zucker\n" +
                        "1TL Salz\n" +
                        "1TL Zitronenschale\n" +
                        "3 Eigelb\n" +
                        "120g Rosinen",
                description = "Mehl in Schüssel und Vertiefung rein, Hefe in lauwarmer Milch auflösen und in Vertiefung geben, mit Mehl vom Rand bedecken, 15 Minuten ruhen lassen, in Zwischenzeit Butter schmelzen (nicht zu heiß) und Zucker, Salz, Zitronenschale und Eigelb einrühren, mit Rosinen und Mehl zu Teig kneten, 1 Stunde gehen lassen, in gefettete Kastenform geben und 10 Minuten gehen lassen, bei 220 Grad 5 Minuten vorbacken, dann bei 180 Grad 25-30 Minuten backen"
            ),
            Recipe(
                id = 17,
                title = "Schoko-Bananen-Muffins",
                type = "cake",
                ingredients = "200g Mehl \n" +
                        "2TL Backpulver\n" +
                        "0,5Tl Natron\n" +
                        "3EL Kakaopulver\n" +
                        "1 Prise Salz\n" +
                        "1 Ei\n" +
                        "150g brauner Zucker\n" +
                        "100ml Öl\n" +
                        "125g Buttermilch\n" +
                        "3 Bananen",
                description = "Mehl mit Backpulver, Natron, Kakaopulver und Salz vermischen, Ei, Zucker, Öl und Buttermilch verrühren, Mehlmischung, Eimischung und pürierte Bananen verrühren, Teig in Muffin-Formen füllen und im vorgeheizten Ofen bei 160 Grad Umluft ca. 25 Minuten backen"
            ),
            Recipe(
                id = 18,
                title = "Schoko-Gugelhupf",
                type = "cake",
                ingredients = "100g Zartbitterschokolade\n" +
                        "225g Butter \n" +
                        "5 Eier\n" +
                        "225g Zucker\n" +
                        "1 Prise Salz\n" +
                        "350g Mehl \n" +
                        "40g Kakaopulver\n" +
                        "1 Päckchen Backpulver\n" +
                        "100ml Milch\n" +
                        "100g Schokostreusel o.Ä.\n" +
                        "\n" +
                        "75g Zartbitterschokolade\n" +
                        "200g Schlagsahne\n" +
                        "20g Kokosfett",
                description = "Zartbitterschokolade und Butter zusammen schmelzen, Eier, Zucker und Salz verrühren, Schokomischung und Milch unterrühren, Mehl, Backpulver und Kakaopulver vermischen und einrühren, Schokostreusel unterrühren, Kuchen im vorgeheizten Ofen bei 175 Grad Umluft ca. 50 Minuten backen, Zartbitterschokolade, Schlagsahne und Kokosfett schmelzen, auf Kuchen geben, abkühlen lassen"
            ),
            Recipe(
                id = 19,
                title = "Schokokuchen",
                type = "cake",
                ingredients = "5 Eier\n" +
                        "200g Zucker\n" +
                        "1 Päckchen Vanillezucker\n" +
                        "1 Prise Salz\n" +
                        "200g Mehl\n" +
                        "2Tl Backpulver\n" +
                        "4EL Kakaopulver\n" +
                        "100ml Öl",
                description = "Eier, Zucker, Vanillezucker und Salz cremig rühren, Mehl, Kakaopulver und Backpulver mischen und unterrühren, Öl einrühren, Kuchen im vorgeheizten Ofen bei 170 Grad Umluft ca. 45 Minuten backen, abkühlen lassen"
            ),
            Recipe(
                id = 20,
                title = "Schokoladen-Muffins",
                type = "cake",
                ingredients = "70g weiche Butter\n" +
                        "190g Zucker\n" +
                        "1 Päckchen Vanillezucker\n" +
                        "1 Ei\n" +
                        "300ml Milch\n" +
                        "1TL Essig \n" +
                        "300g Mehl\n" +
                        "2TL Backpulver\n" +
                        "1TL Salz\n" +
                        "80g Kakaopulver\n" +
                        "100g Schokostreusel o.Ä.",
                description = "Butter, Zucker, Vanillezucker und Ei verrühren, Milch und Essig verrühren und unter Buttermischung rühren, Mehl, Backpulver, Salz, Kakaopulver und Schokostreusel vermischen und in Buttermischung einrühren, Teig in Muffin-Formen geben und im vorgeheizten Ofen bei 150 Grad Umluft ca. 25 Minuten backen"
            ),
            Recipe(
                id = 21,
                title = "Zimtschnecken",
                type = "cake",
                ingredients = "550g Mehl\n" +
                        "65g Zucker\n" +
                        "1TL Salz\n" +
                        "7g Trockenhefe\n" +
                        "1 Ei\n" +
                        "330ml Milch\n" +
                        "75g flüssige Butter \n" +
                        "\n" +
                        "65g weiche Butter \n" +
                        "50g Zucker / Brauner Zucker\n" +
                        "3TL Zimtpulver\n" +
                        "(statt Zimt und Zucker geht auch 115g Nutella)",
                description = "Mehl, Zucker, Salz und Hefe vermischen, Milch lauwarm machen und mit Ei und Butter in Mehlmischung einarbeiten, Teig gut durchkneten, ca. zwei Stunden gehen lassen, Teig ausrollen, mit Butter bestreichen, Zucker und Zimt mischen und auf Teig verteilen (Nutella drauf verstreichen), zu Rolle formen und Schnecken abschneiden (ca. 3cm breit), Schnecken in geölter Auflaufform legen, nochmal an warmen Ort ca. 30 Minuten gehen lassen, Schnecken im vorgeheizten Ofen bei 170 Grad ca. 20 Minuten backen (bis sie oben goldbraun sind), abkühlen lassen und mit Puderzucker oder Zuckerguss überziehen"
            ),
            Recipe(
                id = 22,
                title = "Zitronenkuchen",
                type = "cake",
                ingredients = "180g Zucker \n" +
                        "1 Pck. Vanillezucker\n" +
                        "4 Eier\n" +
                        "240g Mehl \n" +
                        "1 Pck. Backpulver\n" +
                        "Prise Salz\n" +
                        "1 Pck. Zitronenschale / Schale von einer Zitrone \n" +
                        "½ Flasche Zitronenaroma (optional)\n" +
                        "5EL Zitronensaft / Saft einer Zitrone \n" +
                        "200g Sahne\n" +
                        "50g Puderzucker\n" +
                        "2EL Zitronensaft",
                description = "Zucker, Vanillezucker und Ei cremig rühren, Mehl, Backpulver und Salz in zweiter Schüssel vermischen, Mehlmischung, Zitronenschale, Aroma, Zitronensaft und Sahne mit Eimischung verrühren, im vorgeheizten Ofen bei 170 Grad Umluft ca. 40 Minuten backen (am besten in Kastenform), abkühlen lassen, derweil Puderzucker mit Zitronensaft glatt rühren, auf Kuchen verstreichen, vollständig abkühlen lassen"
            ),
            Recipe(
                id = 23,
                title = "Zwetschgen-Datschi",
                type = "cake",
                ingredients = "350g Mehl \n" +
                        "50g Zucker\n" +
                        "1 Päckchen Vanillezucker\n" +
                        "180ml lauwarme Milch\n" +
                        "1 Ei\n" +
                        "1 Päckchen Trockenhefe\n" +
                        "1 Prise Salz\n" +
                        "50ml neutrales Öl\n" +
                        "\n" +
                        "1,5 kg Zwetschgen / 1,5kg Äpfel\n" +
                        "\n" +
                        "300g Mehl \n" +
                        "150g Zucker\n" +
                        "1 Päckchen Vanillezucker\n" +
                        "1TL Zimt \n" +
                        "200g Butter ",
                description = "Mehl, Hefe und Salz vermischen, Ei, Vanillezucker und Zucker schaumig rühren, Mehlmischung, Milch, Butter und Öl zu Teig verarbeiten, mindestens 2 Stunden gehen lassen, Obst kleinschneiden, alles verrühren und 20 Minuten kaltstellen, Hefeteig auf Blech ausrollen und Obst verteilen, gekühlten Teig drüberstreuseln, im vorgeheizten Ofen bei 170 Grad Umluft ca. 35 Minuten backen"
            )
        )
    }
}