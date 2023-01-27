package com.example.rezepte.broteList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rezepte.R

/* A list always displaying one element: the number of rezepte. */

class BroteHeaderAdapter: RecyclerView.Adapter<BroteHeaderAdapter.HeaderViewHolder>() {
    private var rezepteCount: Int = 0

    /* ViewHolder for displaying header. */
    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val rezeptNumberTextView: TextView = itemView.findViewById(R.id.rezept_title)

        fun bind(rezepteCount: Int) {
            rezeptNumberTextView.text = rezepteCount.toString()
        }
    }

    /* Inflates view and returns HeaderViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rezept_item, parent, false)
        return HeaderViewHolder(view)
    }

    /* Binds number of rezepte to the header. */
    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(rezepteCount)
    }

    /* Returns number of items, since there is only one item in the header return one  */
    override fun getItemCount(): Int {
        return 1
    }

    fun updateRezepteCount(updatedRezepteCount: Int) {
        rezepteCount = updatedRezepteCount
        notifyDataSetChanged()
    }
}