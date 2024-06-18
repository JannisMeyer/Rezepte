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

class AdditionsAdapter(private val data: List<Recipe>, val deleteRecipe: (id : Int, title : String) -> Unit) : RecyclerView.Adapter<AdditionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //inflate view and return view holder
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recipe_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        //return number of items the recycler view has to display
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //display concrete item of recycler view as title of corresponding recipe
        val item: Recipe = data[position]
        holder.recipeTitleView.text = item.title
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val context: Context = itemView.context

        //connect recycler view item with recipe title as button
        var recipeTitleView: TextView = itemView.findViewById(R.id.recipe_title)

        init {

            //normal onClickListener referred to onClick-method
            recipeTitleView.setOnClickListener(this)

            //special onClickListener
            recipeTitleView.setOnLongClickListener() {

                deleteRecipe(data[absoluteAdapterPosition].id, data[absoluteAdapterPosition].title)

                //true has to be returned
                true
            }
        }

        override fun onClick(v: View?) {

            //create intent and send recipe attributes of clicked recipe along
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
                putString("TYPE", "addition")
            }
            intent.putExtras(extras)
            context.startActivity(intent)
        }
    }
}