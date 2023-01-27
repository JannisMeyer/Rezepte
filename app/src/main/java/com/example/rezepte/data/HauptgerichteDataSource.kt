package com.example.rezepte.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/* Handles operations on rezepteLiveData and holds details about it. */
class HauptgerichteDataSource(resources: Resources) {
    private val initialHauptgerichteList = hauptgerichteList(resources)
    private val hauptgerichteLiveData = MutableLiveData(initialHauptgerichteList)

    fun getHauptgerichtForId(id: Long): Rezept? {
        hauptgerichteLiveData.value?.let { hauptgerichte ->
            return hauptgerichte.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getHauptgerichteList(): LiveData<List<Rezept>> {
        return hauptgerichteLiveData
    }

    companion object {
        private var INSTANCE: HauptgerichteDataSource? = null

        fun getDataSource(resources: Resources): HauptgerichteDataSource {
            return synchronized(HauptgerichteDataSource::class) {
                val newInstance = INSTANCE ?: HauptgerichteDataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}