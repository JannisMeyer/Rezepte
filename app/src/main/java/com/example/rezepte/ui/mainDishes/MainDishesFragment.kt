package com.example.rezepte.ui.mainDishes

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.adapters.MainDishesAdapter
import com.example.rezepte.addRecipe.AddRecipeActivity
import com.example.rezepte.data.LocalRecipes
import com.example.rezepte.data.MainDishes.Companion.mainDishesList
import com.example.rezepte.data.Recipe
import com.example.rezepte.databinding.FragmentMainDishesBinding


class MainDishesFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentMainDishesBinding? = null
    private val binding get() = _binding!!

    private val addRecipeActivityRequestCode = 1
    private val editRecipeActivityRequestCode = 2

    private var localRecipes = LocalRecipes.getInstance()

    private var mainDishes = this.context?.let { localRecipes?.getMainDishRecipes() }

    private fun loadData() {

        /*val sharedPreferences : SharedPreferences = activity!!.getSharedPreferences("saved_recipes", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("main dishes", null)
        val type : Type = object : TypeToken<MutableList<Recipe>>() {}.type
        mainDishes = gson.fromJson(json, type)
        if(mainDishes == null){
            mainDishes = mainDishesList
            //Toast.makeText(activity, "Loaded data is null! (loadData() in MainDishesFragment)", Toast.LENGTH_SHORT).show()
        }
        for (item in mainDishes!!) {
            item.type = "main dish"
        }*/
        mainDishes = localRecipes?.getMainDishRecipes()
    }


    override fun onResume() {

        super.onResume()

        //to show updated recipe from returned EditRecipeActivity (not optimal, consider to move editing to this fragment)
        loadData()
        val recyclerView = binding.mainDishesRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        showRecipes()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentMainDishesBinding.inflate(inflater, container, false)
        binding.addButton.setOnClickListener(this)
        val recyclerView = binding.mainDishesRecyclerView
        recyclerView.adapter?.notifyDataSetChanged()
        return binding.root
    }

    /*override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState.putInt(COUNT_KEY, count)
    }*/

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
        if(mainDishes != null){
            recipes = mainDishes as MutableList<Recipe>
        }
        else{
            recipes = mainDishesList
            Toast.makeText(activity, "No saved data! (showRecipes() in MainDishesFragment)", Toast.LENGTH_SHORT).show()
        }

        val recyclerView = binding.mainDishesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MainDishesAdapter(recipes, ::deleteRecipe)
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
                    Toast.makeText(activity, "Invalid values (null)! (onActivityResult() in MainDishesFragment)", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else if (requestCode == editRecipeActivityRequestCode) {

            loadData()
            val recyclerView = binding.mainDishesRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
        else if (resultCode == Activity.RESULT_CANCELED) {

            //nothing shall happen if child returned by pressing the back button of the device
            ;
        }
        else {
            Toast.makeText(activity, "Invalid return of activity! (onActivityResult() in MainDishesFragment)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun insertRecipe(recipeTitle: String, recipeIngredients: String, recipeDescription: String) {

        //create new recipe and add it to the list
        val newRecipe = localRecipes?.let { Recipe(id = it.findId(), type = "mainDish", title = recipeTitle, ingredients = recipeIngredients, description = recipeDescription) }
        if (newRecipe != null) {
            mainDishes?.add(newRecipe)

            //sort recipes in alphabetical order, case sensitive
            mainDishes!!.sortBy { it.title }

            //notify adapter of changed data set and save
            val recyclerView = binding.mainDishesRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()

            localRecipes?.writeRecipe(newRecipe, this.requireContext())
            localRecipes?.localRecipes?.add(newRecipe)
        }


    }

    private fun deleteRecipe(recipeId : Int, recipeTitle : String) {

        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setMessage("Rezept \"$recipeTitle\" löschen?")
        alertDialogBuilder.setPositiveButton("Ja") { _, _ ->
            for (item in mainDishes!!) {
                if (item.id == recipeId) {
                    Toast.makeText(activity, "Rezept \"" + item.title + "\" gelöscht", Toast.LENGTH_SHORT).show()
                    mainDishes?.remove(item)
                    localRecipes?.deleteRecipe(recipeId, this.requireContext())
                    break
                }
            }
            val recyclerView = binding.mainDishesRecyclerView
            recyclerView.adapter?.notifyDataSetChanged()
        }
        alertDialogBuilder.setNegativeButton("Nein") { _, _ ->

        }
        alertDialogBuilder.show()
    }
}
