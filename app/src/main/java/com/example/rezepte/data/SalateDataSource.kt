package com.example.rezepte.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/* Handles operations on flowersLiveData and holds details about it. */
class SalateDataSource(resources: Resources) {
    private val initialSalateList = salateList(resources)
    private val salateLiveData = MutableLiveData(initialSalateList)

    fun getSalatForId(id: Long): Rezept? {
        salateLiveData.value?.let { salate ->
            return salate.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getSalateList(): LiveData<List<Rezept>> {
        return salateLiveData
    }

    companion object {
        private var INSTANCE: SalateDataSource? = null

        fun getDataSource(resources: Resources): SalateDataSource {
            return synchronized(SalateDataSource::class) {
                val newInstance = INSTANCE ?: SalateDataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}