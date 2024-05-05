package com.example.rezepte.ui.salads

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
import com.example.rezepte.adapters.SaladsAdapter
import com.example.rezepte.addRecipe.AddRecipeActivity
import com.example.rezepte.data.Salads.Companion.saladList
import com.example.rezepte.data.Recipe
import com.example.rezepte.databinding.FragmentSaladsBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class SaladsFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentSaladsBinding? = null
    private val binding get() = _binding!!

    private val addRecipeActivityRequestCode = 1
    private val editRecipeActivityRequestCode = 2

    private var salads : MutableList<Recipe>? = null

    private fun saveData() {

        if(salads == null){
            salads = saladList
        }
        val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_recipes",
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(salads)
        editor.putString("salads", json)
        editor.apply()
    }

    private fun loadData() {

        val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_recipes",
            Context.MODE_PRIVATE
        )
        val gson = Gson()
        val json = sharedPreferences.getString("salads", null)
        val type : Type = object : TypeToken<MutableList<Recipe>>() {}.type
        salads = gson.fromJson(json, type)
        if(salads == null){
            salads = saladList
            //Toast.makeText(activity, "Loaded data is null! (loadData() in SaladsFragment)", Toast.LENGTH_SHORT).show()
        }
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

        saveData()
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
        val newRecipe = Recipe(type = "salad", title = recipeTitle, ingredients = recipeIngredients, description = recipeDescription)
        salads?.add(newRecipe)

        //sort recipes in alphabetical order, case sensitive
        salads!!.sortBy { it.title }

        //notify adapter of changed data set and save
        val recyclerView = binding.saladsRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        saveData()
    }

    private fun deleteRecipe(recipeId : String, recipeTitle : String) {

        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setMessage("Rezept \"$recipeTitle\" löschen?")
        alertDialogBuilder.setPositiveButton("Ja") { _, _ ->
            for (item in salads!!) {
                if (item.id == recipeId.toInt()) {
                    Toast.makeText(activity, "Rezept \"" + item.title + "\" gelöscht", Toast.LENGTH_SHORT).show()
                    salads?.remove(item)
                    break
                }
            }
            val recyclerView = binding.saladsRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
            saveData()
        }
        alertDialogBuilder.setNegativeButton("Nein") { _, _ ->

        }
        alertDialogBuilder.show()
    }
}

