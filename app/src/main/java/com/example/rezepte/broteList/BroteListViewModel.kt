package com.example.rezepte.broteList

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rezepte.data.BroteDataSource
import com.example.rezepte.data.Rezept
import kotlin.random.Random

class BroteListViewModel(val dataSource: BroteDataSource) : ViewModel() {

    val rezepteLiveData = dataSource.getBroteList()
}

class BroteListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BroteListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BroteListViewModel(
                dataSource = BroteDataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}