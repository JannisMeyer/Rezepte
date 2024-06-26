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
import com.example.rezepte.data.Recipe
import com.example.rezepte.recipeDetail.RecipeDetailActivity

class CakesAdapter(private val data: List<Recipe>, val deleteRecipe: (id : Int, title : String) -> Unit) : RecyclerView.Adapter<CakesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recipe_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Recipe = data[position]
        holder.recipeTitleView.text = item.title
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val context: Context = itemView.context

        var recipeTitleView: TextView = itemView.findViewById(R.id.recipe_title)

        init {
            recipeTitleView.setOnClickListener(this)
            recipeTitleView.setOnLongClickListener() {

                deleteRecipe(data[absoluteAdapterPosition].id, data[absoluteAdapterPosition].title)

                true
            }
        }

        override fun onClick(v: View?) {
            val intent = Intent(context, RecipeDetailActivity::class.java)
            val recipeId: Int = data[adapterPosition].id
            val recipeTitle: String = data[adapterPosition].title
            val recipeIngredients: String = data[adapterPosition].ingredients
            val recipeDescription: String = data[adapterPosition].description

            val extras = Bundle().apply {
                putString("ID", recipeId.toString())
                putString("TITLE", recipeTitle)
                putString("INGREDIENTS", recipeIngredients)
                putString("DESCRIPTION", recipeDescription)
                putString("TYPE", "cake")
            }
            intent.putExtras(extras)
            context.startActivity(intent)
        }
    }
}