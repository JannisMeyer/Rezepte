package com.example.rezepte.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ZusaetzeDataSource(resources: Resources) {
    private val initialZusaetzeList = zusaetzeList(resources)
    private val zusaetzeLiveData = MutableLiveData(initialZusaetzeList)

    fun getZusatzForId(id: Long): Rezept? {
        zusaetzeLiveData.value?.let { zusatz ->
            return zusatz.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getZusaetzeList(): LiveData<List<Rezept>> {
        return zusaetzeLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}