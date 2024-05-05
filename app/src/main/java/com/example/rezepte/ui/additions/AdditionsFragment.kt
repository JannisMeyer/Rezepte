package com.example.rezepte.ui.additions

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.adapters.AdditionsAdapter
import com.example.rezepte.addRecipe.AddRecipeActivity
import com.example.rezepte.data.Additions.Companion.additionsList
import com.example.rezepte.data.Recipe
import com.example.rezepte.databinding.FragmentAdditionsBinding
import com.example.rezepte.recipeDatabase.RecipeDBInterface
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class AdditionsFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentAdditionsBinding? = null
    private val binding get() = _binding!!

    //for return of edit or add recipe activity
    private val addRecipeActivityRequestCode = 1
    private val editRecipeActivityRequestCode = 2

    private var additions : MutableList<Recipe>? = null

    private fun saveData() {

        //if there is no saved data yet, set recipes to hard coded recipes in "data"-folder
        if(additions == null){
            additions = additionsList
        }
        val dbInterface = RecipeDBInterface(this.requireContext())
        dbInterface.writeToDB(additions!!, "addition")
    }

    private fun loadData() {
        val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_recipes",
            Context.MODE_PRIVATE
        )
        val gson = Gson()
        val json = sharedPreferences.getString("additions", null)
        val type : Type = object : TypeToken<MutableList<Recipe>>() {}.type
        additions = gson.fromJson(json, type)
        if(additions == null){
            additions = additionsList
            //Toast.makeText(activity, "Loaded data is null! (loadData() in AdditionsFragment)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {

        super.onResume()

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

        //save data if other fragment is loaded
        saveData()
        _binding = null
    }

    private fun showRecipes() {
        lateinit var recipes:MutableList<Recipe>
        if(additions != null){
            recipes = additions as MutableList<Recipe>
        }
        else{
            recipes = additionsList
            Toast.makeText(activity, "No saved data! (showRezepte() in AdditionsFragment)", Toast.LENGTH_SHORT).show()
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
        val newRecipe = Recipe(type = "addition", title = recipeTitle, ingredients = recipeIngredients, description = recipeDescription)
        additions?.add(newRecipe)

        //sort recipes in alphabetical order, case sensitive
        additions!!.sortBy { it.title }

        //notify adapter of changed data set and save
        val recyclerView = binding.additionsRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        saveData()
    }

    private fun deleteRecipe(recipeId : String, recipeTitle : String) {

        //create assurance of deletion
        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setMessage("Rezept \"$recipeTitle\" löschen?")
        alertDialogBuilder.setPositiveButton("Ja") { _, _ ->

            //find recipe to delete by id and remove
            for (item in additions!!) {
                if (item.id == recipeId.toInt()) {
                    Toast.makeText(activity, "Rezept \"" + item.title + "\" gelöscht", Toast.LENGTH_SHORT).show()
                    additions?.remove(item)
                    break
                }
            }

            //inform recyclerView of updated recipe data
            val recyclerView = binding.additionsRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
            saveData()
        }
        alertDialogBuilder.setNegativeButton("Nein") { _, _ ->

        }
        alertDialogBuilder.show()
    }
}
