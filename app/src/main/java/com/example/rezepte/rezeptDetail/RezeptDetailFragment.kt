package com.example.rezepte.rezeptDetail

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.rezepte.R
import com.example.rezepte.broteList.REZEPT_ID

class RezeptDetailFragment : AppCompatActivity() {

    private val RezeptDetailViewModel by viewModels<RezeptDetailViewModel> {
        RezeptDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rezept_detail_fragment)

        var currentRezeptId: Long? = null

        /* Connect variables to UI elements. */
        val rezeptTitel: TextView = findViewById(R.id.rezept_detail_titel)
        val rezeptZutaten: TextView = findViewById(R.id.rezept_detail_zutaten)
        val rezeptBeschreibung: TextView = findViewById(R.id.rezept_detail_beschreibung)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentRezeptId = bundle.getLong(REZEPT_ID)
        }

        /* If currentRezeptId is not null, get corresponding rezept and set values */
        currentRezeptId?.let {
            val currentRezept = RezeptDetailViewModel.getRezeptForId(it)
            rezeptTitel.text = currentRezept?.Titel
            rezeptZutaten.text = currentRezept?.Zutaten
            rezeptBeschreibung.text = currentRezept?.Beschreibung
        }

    }
}