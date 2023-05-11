package com.example.rezepte.rezeptDetail

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
//import com.example.rezepte.rezeptDetail.RezeptDetailFragment
import com.example.rezepte.R
import com.example.rezepte.data.Rezept
import com.example.rezepte.databinding.RezeptDetailFragmentBinding

class RezeptDetailFragment : AppCompatActivity() {

    private lateinit var binding: RezeptDetailFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = RezeptDetailFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deleteButton.setOnClickListener {
            TODO("add functionality")
        }

        binding.editButton.setOnClickListener {
            TODO("add functionality")
        }

        val extras = intent.extras

        val recipe_titel_view: TextView = findViewById(R.id.rezept_detail_titel)
        val recipe_zutaten_view: TextView = findViewById(R.id.rezept_detail_zutaten)
        val recipe_beschreibung_view: TextView = findViewById(R.id.rezept_detail_beschreibung)

        recipe_titel_view.text = extras?.getString("TITEL")
        recipe_zutaten_view.text = extras?.getString("ZUTATEN")
        recipe_beschreibung_view.text = extras?.getString("BESCHR")
    }
}