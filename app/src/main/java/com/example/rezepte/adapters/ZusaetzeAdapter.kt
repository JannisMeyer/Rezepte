package com.example.rezepte.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.rezepte.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rezepte.data.Rezept
import com.example.rezepte.rezeptDetail.RezeptDetailFragment

class ZusaetzeAdapter(private val data: List<Rezept>) : RecyclerView.Adapter<ZusaetzeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.rezept_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Rezept = data[position]
        holder.rezept_titelView.text = item.Titel
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val context: Context = itemView.context

        var rezept_titelView: TextView = itemView.findViewById(R.id.rezept_title)

        init {
            rezept_titelView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val intent = Intent(context, RezeptDetailFragment::class.java)
            val rezept_id: Int = data[adapterPosition].id
            val rezept_titel: String = data[adapterPosition].Titel
            val rezept_zutaten: String = data[adapterPosition].Zutaten
            val rezept_beschreibung: String = data[adapterPosition].Beschreibung

            val extras = Bundle().apply {
                putString("ID", rezept_id.toString())
                putString("TITEL", rezept_titel)
                putString("ZUTATEN", rezept_zutaten)
                putString("BESCHR", rezept_beschreibung)
            }
            intent.putExtras(extras)
            context.startActivity(intent)
        }
    }
}