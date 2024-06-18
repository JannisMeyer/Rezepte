package com.example.rezepte.ui.additions

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
import com.example.rezepte.adapters.AdditionsAdapter
import com.example.rezepte.addRecipe.AddRecipeActivity
import com.example.rezepte.data.Additions.Companion.additionsList
import com.example.rezepte.data.LocalRecipes
import com.example.rezepte.data.Recipe
import com.example.rezepte.databinding.FragmentAdditionsBinding

class AdditionsFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentAdditionsBinding? = null
    private val binding get() = _binding!!

    //for return of edit or add recipe activity
    private val addRecipeActivityRequestCode = 1
    private val editRecipeActivityRequestCode = 2

    private var localRecipes = LocalRecipes.getInstance()

    private var additions = this.context?.let { localRecipes?.getAdditionRecipes() }

    private fun loadData() {

        additions = localRecipes?.getAdditionRecipes()
    }

    override fun onResume() {

        super.onResume()
        Log.d(ContentValues.TAG, "on resume")

        //to show updated recipe from returned EditRecipeActivity (not optimal, considering to move editing to this fragment)
        loadData()

        //recyclerView has to be informed of possibly changed recipes
        val recyclerView = binding.additionsRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        showRecipes()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentAdditionsBinding.inflate(inflater, container, false)
        binding.addButton.setOnClickListener(this)
        val recyclerView = binding.additionsRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        return binding.root
    }

    override fun onClick(v: View?) {

        //start addRecipeActivity if button is clicked
        val intent = Intent(activity, AddRecipeActivity::class.java)
        startActivityForResult(intent, addRecipeActivityRequestCode)
    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null
    }

    private fun showRecipes() {
        lateinit var recipes:MutableList<Recipe>
        if(additions != null){
            recipes = additions as MutableList<Recipe>
        }
        else{
            recipes = additionsList
            Toast.makeText(activity, "No saved data! (showRecipes() in AdditionsFragment)", Toast.LENGTH_SHORT).show()
        }

        //supply recyclerView with actual recipe data
        val recyclerView = binding.additionsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AdditionsAdapter(recipes, ::deleteRecipe)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {

        super.onActivityResult(requestCode, resultCode, intentData)

        //handle return of adding recipe activity
        if (requestCode == addRecipeActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val recipeTitle = data.getStringExtra("RECIPE_TITLE")
                val recipeIngredients = data.getStringExtra("RECIPE_INGREDIENTS")
                val recipeDescription = data.getStringExtra("RECIPE_DESCRIPTION")

                //insert new recipe
                if (recipeTitle != null && recipeIngredients != null && recipeDescription != null) {
                    insertRecipe(recipeTitle, recipeIngredients, recipeDescription)
                }
                else {
                    Toast.makeText(activity, "Invalid values (null)! (onActivityResult() in AdditionsFragment)", Toast.LENGTH_SHORT).show()
                }
            }
        }

        //handle return of edit recipe activity ()
        else if (requestCode == editRecipeActivityRequestCode) {

            loadData()
            val recyclerView = binding.additionsRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
        else if (resultCode == Activity.RESULT_CANCELED) {

            //nothing shall happen if child returned by pressing the back button of the device
            ;
        }
        else {
            Toast.makeText(activity, "Invalid return of activity! (onActivityResult() in AdditionsFragment)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertRecipe(recipeTitle: String, recipeIngredients: String, recipeDescription: String) {

        //create new recipe and add it to the list
        val newRecipe = localRecipes?.let { Recipe(id = it.findId(), type = "addition", title = recipeTitle, ingredients = recipeIngredients, description = recipeDescription) }
        if (newRecipe != null) {

            // add recipe
            localRecipes?.writeRecipe(newRecipe, this.requireContext())
            loadData()

            //notify adapter of changed data set and save
            val recyclerView = binding.additionsRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    private fun deleteRecipe(recipeId : Int, recipeTitle : String) {

        //create assurance of deletion
        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setMessage("Rezept \"$recipeTitle\" löschen?")
        alertDialogBuilder.setPositiveButton("Ja") { _, _ ->

            //find recipe to delete by id and remove
            for (item in additions!!) {
                if (item.id == recipeId) {
                    Toast.makeText(activity, "Rezept \"" + item.title + "\" gelöscht", Toast.LENGTH_SHORT).show()
                    additions?.remove(item)
                    localRecipes?.deleteRecipe(recipeId, this.requireContext())
                    break
                }
            }
            val recyclerView = binding.additionsRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
        alertDialogBuilder.setNegativeButton("Nein") { _, _ ->

        }
        alertDialogBuilder.show()
    }
}
