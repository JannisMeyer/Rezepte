package com.example.rezepte.ui.hauptgerichte

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.R
import com.example.rezepte.adapters.HauptgerichteAdapter
import com.example.rezepte.data.hauptgerichteList
import com.example.rezepte.databinding.FragmentHauptgerichteBinding
import com.example.rezepte.ui.AddRecipeActivity
import com.example.rezepte.ui.RECIPE_DESCRIPTION
import com.example.rezepte.ui.RECIPE_INGREDIENTS
import com.example.rezepte.ui.RECIPE_TITLE


class HauptgerichteFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHauptgerichteBinding? = null
    private val binding get() = _binding!!

    private val newRecipeActivityRequestCode = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHauptgerichteBinding.inflate(inflater, container, false)
        val myView: View = inflater.inflate(R.layout.fragment_hauptgerichte, container, false)
        val myButton = myView.findViewById(R.id.add_button) as Button
        myButton.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, AddRecipeActivity::class.java)
        startActivityForResult(intent, newRecipeActivityRequestCode)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showRezepte()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showRezepte() {
        val rezepte = hauptgerichteList(resources)

        val recyclerView = binding.hauptgerichteRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HauptgerichteAdapter(rezepte)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newRecipeActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val recipeTitle = data.getStringExtra(RECIPE_TITLE)
                val recipeIngredients = data.getStringExtra(RECIPE_INGREDIENTS)
                val recipeDescription = data.getStringExtra(RECIPE_DESCRIPTION)

                insertRecipe(recipeTitle, recipeIngredients, recipeDescription)
            }
        }
    }

    private fun insertRecipe(recipeTitle: String?, recipeIngredients: String?, recipeDescription: String?) {

    }
}
