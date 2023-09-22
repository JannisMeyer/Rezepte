package com.example.rezepte.ui.brot

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
import com.example.rezepte.adapters.BroteAdapter
import com.example.rezepte.addRecipe.AddRecipeActivity
import com.example.rezepte.data.Breads.Companion.brotListe
import com.example.rezepte.data.Rezept
import com.example.rezepte.databinding.FragmentBrotBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class BrotFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentBrotBinding? = null
    private val binding get() = _binding!!

    private val addRecipeActivityRequestCode = 1
    private val editRecipeActivityRequestCode = 2

    private var breads : MutableList<Rezept>? = null

    private fun saveData() {
        //Toast.makeText(activity, "saveData() called!", Toast.LENGTH_SHORT).show()
        if(breads == null){
            breads = brotListe
        }
        val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_recipes",
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(breads)
        editor.putString("breads", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_recipes",
            Context.MODE_PRIVATE
        )
        val gson = Gson()
        val json = sharedPreferences.getString("breads", null)
        val type : Type = object : TypeToken<MutableList<Rezept>>() {}.type
        breads = gson.fromJson(json, type)
        if(breads == null){ //for testing
            breads = brotListe
            Toast.makeText(activity, "Loaded data is null! (loadData())", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(activity, "onResume() called!", Toast.LENGTH_SHORT).show()

        //to show updated recipe from returned EditRecipeActivity (not optimal, considering to move editing to this fragment)
        loadData()
        val recyclerView = binding.brotRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        showRezepte()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBrotBinding.inflate(inflater, container, false)
        binding.addButton.setOnClickListener(this)
        //Toast.makeText(activity, "onCreateView called!", Toast.LENGTH_SHORT).show()
        val recyclerView = binding.brotRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        return binding.root
    }

    override fun onClick(v: View?) {
        //Toast.makeText(activity, "addButton clicked (onClick())!", Toast.LENGTH_SHORT).show() //for testing
        val intent = Intent(activity, AddRecipeActivity::class.java)
        startActivityForResult(intent, addRecipeActivityRequestCode)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        saveData()
        _binding = null
    }

    private fun showRezepte() {
        lateinit var rezepte:MutableList<Rezept>
        if(breads != null){
            rezepte = breads as MutableList<Rezept>
        }
        else{
            rezepte = brotListe
            Toast.makeText(activity, "No saved data (showRezepte())!", Toast.LENGTH_SHORT).show() //for testing
        }

        val recyclerView = binding.brotRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BroteAdapter(rezepte, ::deleteRecipe)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        //Toast.makeText(context, "Activity returned!", Toast.LENGTH_SHORT).show() //for testing
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
                    Toast.makeText(activity, "Invalid values (null) (onActivityResult())!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else if (requestCode == editRecipeActivityRequestCode) {
            Toast.makeText(activity, "Returned from editing recipe!", Toast.LENGTH_SHORT).show()
            loadData()
            val recyclerView = binding.brotRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
        else {
            Toast.makeText(activity, "Invalid return of activity (onActivityResult())!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertRecipe(recipeTitle: String, recipeIngredients: String, recipeDescription: String) {

        //find unused identifying number
        var identification = 0
        var idFound : Boolean
        while (true) {
            idFound = true
            identification++
            for(item in breads!!) {
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
        val newRecipe = Rezept(identification, recipeTitle, recipeIngredients, recipeDescription)
        breads?.add(newRecipe)

        //sort recipes in alphabetical order, case sensitive
        breads!!.sortBy { it.Titel }

        //notify adapter of changed data set and save
        val recyclerView = binding.brotRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        saveData()

        /*//for testing
        Toast.makeText(activity, "insertRecipe() called!", Toast.LENGTH_SHORT).show()
        test = 1;
        binding.textHauptgerichte.text = test.toString()*/
    }

    private fun deleteRecipe(recipeId : String, recipeTitle : String) {

        //Toast.makeText(activity, "id: $recipeId", Toast.LENGTH_SHORT).show()

        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setMessage("Rezept \"$recipeTitle\" löschen?")
        alertDialogBuilder.setPositiveButton("Ja") { _, _ ->
            for (item in breads!!) {
                if (item.id == recipeId.toInt()) {
                    Toast.makeText(activity, "delete recipe "+item.Titel, Toast.LENGTH_SHORT).show()
                    breads?.remove(item)
                    break
                }
            }
            val recyclerView = binding.brotRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
            saveData()
        }
        alertDialogBuilder.setNegativeButton("Nein") { _, _ ->

        }
        alertDialogBuilder.show()
    }
}