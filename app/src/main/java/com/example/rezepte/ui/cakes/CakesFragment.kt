package com.example.rezepte.ui.cakes

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
import com.example.rezepte.adapters.CakesAdapter
import com.example.rezepte.addRecipe.AddRecipeActivity
import com.example.rezepte.data.Cakes.Companion.cakeList
import com.example.rezepte.data.Recipe
import com.example.rezepte.databinding.FragmentCakesBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CakesFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentCakesBinding? = null
    private val binding get() = _binding!!

    private val addRecipeActivityRequestCode = 1
    private val editRecipeActivityRequestCode = 2

    private var cakes : MutableList<Recipe>? = null

    private fun saveData() {

        if(cakes == null){
            cakes = cakeList
        }
        val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_recipes",
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(cakes)
        editor.putString("cakes", json)
        editor.apply()
    }

    private fun loadData() {

        val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_recipes",
            Context.MODE_PRIVATE
        )
        val gson = Gson()
        val json = sharedPreferences.getString("cakes", null)
        val type : Type = object : TypeToken<MutableList<Recipe>>() {}.type
        cakes = gson.fromJson(json, type)
        if(cakes == null){ //for testing
            cakes = cakeList
            //Toast.makeText(activity, "Loaded data is null! (loadData() in CakesFragment)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {

        super.onResume()

        //to show updated recipe from returned EditRecipeActivity (not optimal, considering to move editing to this fragment)
        loadData()
        val recyclerView = binding.cakesRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        showRecipes()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentCakesBinding.inflate(inflater, container, false)
        binding.addButton.setOnClickListener(this)
        val recyclerView = binding.cakesRecyclerView
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

        lateinit var rezepte:MutableList<Recipe>
        if(cakes != null){
            rezepte = cakes as MutableList<Recipe>
        }
        else{
            rezepte = cakeList
            Toast.makeText(activity, "No saved data! (showRecipes() in CakesFragment)", Toast.LENGTH_SHORT).show() //for testing
        }

        val recyclerView = binding.cakesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CakesAdapter(rezepte, ::deleteRecipe)
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
                    Toast.makeText(activity, "Invalid values (null)! (onActivityResult() in CakeFragment)", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else if (requestCode == editRecipeActivityRequestCode) {
            loadData()
            val recyclerView = binding.cakesRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
        else if (resultCode == Activity.RESULT_CANCELED) {

            //nothing shall happen if child returned by pressing the back button of the device
            ;
        }
        else {
            Toast.makeText(activity, "Invalid return of activity! (onActivityResult() in CakesFragment)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertRecipe(recipeTitle: String, recipeIngredients: String, recipeDescription: String) {

        //find unused identifying number
        var identification = 0
        var idFound : Boolean
        while (true) {
            idFound = true
            identification++
            for(item in cakes!!) {
                if (item.id == identification) {
                    idFound = false
                    break
                }
            }
            if (idFound) {
                break
            }
        }

        //create new recipe and add it to the list
        val newRecipe = Recipe(identification, recipeTitle, recipeIngredients, recipeDescription)
        cakes?.add(newRecipe)

        //sort recipes in alphabetical order, case sensitive
        cakes!!.sortBy { it.title }

        //notify adapter of changed data set and save
        val recyclerView = binding.cakesRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        saveData()
    }

    private fun deleteRecipe(recipeId : String, recipeTitle : String) {

        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setMessage("Rezept \"$recipeTitle\" löschen?")
        alertDialogBuilder.setPositiveButton("Ja") { _, _ ->
            for (item in cakes!!) {
                if (item.id == recipeId.toInt()) {
                    Toast.makeText(activity, "Rezept \"" + item.title + "\" gelöscht", Toast.LENGTH_SHORT).show()
                    cakes?.remove(item)
                    break
                }
            }
            val recyclerView = binding.cakesRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
            saveData()
        }
        alertDialogBuilder.setNegativeButton("Nein") { _, _ ->

        }
        alertDialogBuilder.show()
    }
}