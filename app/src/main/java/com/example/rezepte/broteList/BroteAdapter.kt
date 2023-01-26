package com.example.rezepte.broteList

import com.example.rezepte.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rezepte.data.Rezept

class BroteAdapter(private val onClick: (Rezept) -> Unit) :
    ListAdapter<Rezept, BroteAdapter.BroteViewHolder>(BrotDiffCallback) {

    /* ViewHolder for Flower, takes in the inflated view and the onClick behavior. */
    class BroteViewHolder(itemView: View, val onClick: (Rezept) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val rezeptTextView: TextView = itemView.findViewById(R.id.rezept_title)
        private var currentRezept: Rezept? = null

        init {
            itemView.setOnClickListener {
                currentRezept?.let {
                    onClick(it)
                }
            }
        }

        /* Bind rezept titel. */
        fun bind(rezept: Rezept) {
            currentRezept = rezept

            rezeptTextView.text = rezept.Titel
        }
    }

    /* Creates and inflates view and return BroteViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BroteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rezept_item, parent, false)
        return BroteViewHolder(view, onClick)
    }

    /* Gets current rezept and uses it to bind view. */
    override fun onBindViewHolder(holder: BroteViewHolder, position: Int) {
        val flower = getItem(position)
        holder.bind(flower)

    }
}

object BrotDiffCallback : DiffUtil.ItemCallback<Rezept>() {
    override fun areItemsTheSame(oldItem: Rezept, newItem: Rezept): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Rezept, newItem: Rezept): Boolean {
        return oldItem.id == newItem.id
    }
}