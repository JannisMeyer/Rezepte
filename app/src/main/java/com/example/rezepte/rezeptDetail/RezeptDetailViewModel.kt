package com.example.rezepte.rezeptDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rezepte.data.BroteDataSource
import com.example.rezepte.data.Rezept

class RezeptDetailViewModel(private val datasource: BroteDataSource) : ViewModel() {

    /* Queries datasource to returns a rezept that corresponds to an id. */
    fun getBrotForId(id: Long) : Rezept? {
        return datasource.getBrotForId(id)
    }
}

class RezeptDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RezeptDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RezeptDetailViewModel(
                datasource = BroteDataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}