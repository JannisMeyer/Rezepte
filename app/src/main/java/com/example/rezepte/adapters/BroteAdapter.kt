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
import com.example.rezepte.rezeptDetail.RezeptDetailActivity

class BroteAdapter(private val data: List<Rezept>, val deleteRecipe: (id : String, title : String) -> Unit) : RecyclerView.Adapter<BroteAdapter.ViewHolder>() {

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
        holder.rezeptTitelView.text = item.Titel
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val context: Context = itemView.context

        var rezeptTitelView: TextView = itemView.findViewById(R.id.rezept_title)

        init {
            rezeptTitelView.setOnClickListener(this)
            rezeptTitelView.setOnLongClickListener() {

                // For testing
                //Toast.makeText(itemView.context,"This is a long click",Toast.LENGTH_SHORT).show();

                deleteRecipe(data[absoluteAdapterPosition].id.toString(), data[absoluteAdapterPosition].Titel)

                true
            }
        }

        override fun onClick(v: View?) {
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
                putString("TYPE", "breads")
            }
            intent.putExtras(extras)
            context.startActivity(intent)
        }
    }
}