package com.example.rezepte.ui.salads

import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.adapters.SaladsAdapter
import com.example.rezepte.addRecipe.AddRecipeActivity
import com.example.rezepte.data.Additions
import com.example.rezepte.data.LocalRecipes
import com.example.rezepte.data.Salads.Companion.saladList
import com.example.rezepte.data.Recipe
import com.example.rezepte.databinding.FragmentSaladsBinding

class SaladsFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSaladsBinding? = null
    private val binding get() = _binding!!

    private val addRecipeActivityRequestCode = 1
    private val editRecipeActivityRequestCode = 2

    private var localRecipes = LocalRecipes.getInstance()

    private var salads = this.context?.let { localRecipes?.getCakeRecipes() }

    private fun loadData() {

        salads = localRecipes?.getSaladRecipes()
    }

    override fun onResume() {

        super.onResume()

        //to show updated recipe from returned EditRecipeActivity (not optimal, considering to move editing to this fragment)
        loadData()
        val recyclerView = binding.saladsRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        showRecipes()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentSaladsBinding.inflate(inflater, container, false)
        binding.addButton.setOnClickListener(this)
        val recyclerView = binding.saladsRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        return binding.root
    }

    override fun onClick(v: View?) {

        val intent = Intent(activity, AddRecipeActivity::class.java)
        startActivityForResult(intent, addRecipeActivityRequestCode)
    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null
    }

    private fun showRecipes() {

        lateinit var recipes:MutableList<Recipe>
        if(salads != null){
            recipes = salads as MutableList<Recipe>
        }
        else{
            recipes = saladList
            Toast.makeText(activity, "No saved data! (showRecipes() in SaladsFragment)", Toast.LENGTH_SHORT).show()
        }

        val recyclerView = binding.saladsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SaladsAdapter(recipes, ::deleteRecipe)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {

        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == addRecipeActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val recipeTitle = data.getStringExtra("RECIPE_TITLE")
                val recipeIngredients = data.getStringExtra("RECIPE_INGREDIENTS")
                val recipeDescription = data.getStringExtra("RECIPE_DESCRIPTION")

                if (recipeTitle != null && recipeIngredients != null && recipeDescription != null) {
                    insertRecipe(recipeTitle, recipeIngredients, recipeDescription)
                }
                else {
                    Toast.makeText(activity, "Invalid values (null)! (onActivityResult() in SaladsFragment)", Toast.LENGTH_SHORT).show()
                }
            }
        }

        //handle return of edit recipe activity
        else if (requestCode == editRecipeActivityRequestCode) {
            loadData()
            val recyclerView = binding.saladsRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
        else if (resultCode == Activity.RESULT_CANCELED) {

            //nothing shall happen if child returned by pressing the back button of the device
            ;
        }
        else {
            Toast.makeText(activity, "Invalid return of activity! (onActivityResult() in SaladsFragment)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertRecipe(recipeTitle: String, recipeIngredients: String, recipeDescription: String) {

        //create new recipe and add it to the list
        val newRecipe = localRecipes?.let { Recipe(id = it.findId(), type = "salad", title = recipeTitle, ingredients = recipeIngredients, description = recipeDescription) }
        if (newRecipe != null) {

            // add recipe
            localRecipes?.writeRecipe(newRecipe, this.requireContext())
            loadData()

            //notify adapter of changed data set and save
            val recyclerView = binding.saladsRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    private fun deleteRecipe(recipeId : Int, recipeTitle : String) {

        //create assurance of deletion
        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setMessage("Rezept \"$recipeTitle\" löschen?")
        alertDialogBuilder.setPositiveButton("Ja") { _, _ ->

            //find recipe to delete by id and remove
            for (item in salads!!) {
                if (item.id == recipeId) {
                    Toast.makeText(activity, "Rezept \"" + item.title + "\" gelöscht", Toast.LENGTH_SHORT).show()
                    salads?.remove(item)
                    localRecipes?.deleteRecipe(recipeId, this.requireContext())
                    break
                }
            }
            val recyclerView = binding.saladsRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
        alertDialogBuilder.setNegativeButton("Nein") { _, _ ->

        }
        alertDialogBuilder.show()
    }
}

