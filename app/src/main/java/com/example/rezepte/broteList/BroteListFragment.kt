package com.example.rezepte.broteList

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rezepte.rezeptDetail.RezeptDetailFragment
import com.example.rezepte.R
import com.example.rezepte.data.Rezept

const val REZEPT_ID = "rezept id"

class BroteListFragment : AppCompatActivity() {
    private val newBroteFragmentRequestCode = 1
    private val broteListViewModel by viewModels<BroteListViewModel> {
        BroteListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Instantiates headerAdapter and flowersAdapter. Both adapters are added to concatAdapter.
        which displays the contents sequentially */
        val headerAdapter = BroteHeaderAdapter()
        val broteAdapter = BroteAdapter { rezept -> adapterOnClick(rezept) }
        val concatAdapter = ConcatAdapter(headerAdapter, broteAdapter)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = concatAdapter

        broteListViewModel.rezepteLiveData.observe(this, {
            it?.let {
                broteAdapter.submitList(it as MutableList<Rezept>)
                headerAdapter.updateRezepteCount(it.size)
            }
        })
    }

    /* Opens FlowerDetailActivity when RecyclerView item is clicked. */
    private fun adapterOnClick(rezept: Rezept) {
        val intent = Intent(this, RezeptDetailFragment()::class.java)
        intent.putExtra(REZEPT_ID, rezept.id)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)
    }
}