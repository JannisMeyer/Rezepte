package com.example.rezepte.adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.rezepte.R
import com.example.rezepte.data.Rezept
import com.example.rezepte.rezeptDetail.RezeptDetailActivity
import com.example.rezepte.ui.hauptgerichte.HauptgerichteFragment

class HauptgerichteAdapter(private val data: List<Rezept>, val deleteRecipe: (id : String) -> Unit) : RecyclerView.Adapter<HauptgerichteAdapter.ViewHolder>() {

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
            rezept_titelView.setOnLongClickListener() {

                // For testing
                //Toast.makeText(itemView.context,"This is a long click",Toast.LENGTH_SHORT).show();

                deleteRecipe(data[absoluteAdapterPosition].id.toString())

                true
            }
        }

        override fun onClick(v: View?) {
            //Toast.makeText(context, "Clicked main dish!", Toast.LENGTH_SHORT).show() //for testing
            val intent: Intent = Intent(context, RezeptDetailActivity::class.java)
            val rezept_id: Int = data[adapterPosition].id
            val rezept_titel: String = data[adapterPosition].Titel
            val rezept_zutaten: String = data[adapterPosition].Zutaten
            val rezept_beschreibung: String = data[adapterPosition].Beschreibung

            val extras = Bundle().apply {
                putString("ID", rezept_id.toString())
                putString("TITEL", rezept_titel)
                putString("ZUTATEN", rezept_zutaten)
                putString("BESCHR", rezept_beschreibung)
                putString("TYPE", "main dishes")
            }
            intent.putExtras(extras)
            context.startActivity(intent)
        }
    }
}