package com.example.rezepte.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rezepte.R
import com.example.rezepte.data.Rezept
import com.example.rezepte.rezeptDetail.RezeptDetailActivity

class HauptgerichteAdapter(private val data: List<Rezept>, val deleteRecipe: (id : String, title : String) -> Unit) : RecyclerView.Adapter<HauptgerichteAdapter.ViewHolder>() {

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
            //Toast.makeText(context, "Clicked main dish!", Toast.LENGTH_SHORT).show() //for testing
            val intent: Intent = Intent(context, RezeptDetailActivity::class.java)
            val rezeptId: Int = data[adapterPosition].id
            val rezeptTitel: String = data[adapterPosition].Titel
            val rezeptZutaten: String = data[adapterPosition].Zutaten
            val rezeptBeschreibung: String = data[adapterPosition].Beschreibung

            val extras = Bundle().apply {
                putString("ID", rezeptId.toString())
                putString("TITEL", rezeptTitel)
                putString("ZUTATEN", rezeptZutaten)
                putString("BESCHR", rezeptBeschreibung)
                putString("TYPE", "main dishes")
            }
            intent.putExtras(extras)
            context.startActivity(intent)
        }
    }
}