package com.example.rezepte.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/* Handles operations on flowersLiveData and holds details about it. */
class BroteDataSource(resources: Resources) {
    private val initialBroteList = broteList(resources)
    private val broteLiveData = MutableLiveData(initialBroteList)

    fun getBrotForId(id: Long): Rezept? {
        broteLiveData.value?.let { brote ->
            return brote.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getBroteList(): LiveData<List<Rezept>> {
        return broteLiveData
    }

    companion object {
        private var INSTANCE: BroteDataSource? = null

        fun getDataSource(resources: Resources): BroteDataSource {
            return synchronized(BroteDataSource::class) {
                val newInstance = INSTANCE ?: BroteDataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}