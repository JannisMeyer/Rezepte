package com.example.rezepte.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class KuchenDataSource(resources: Resources) {
    private val initialKuchenList = kuchenList(resources)
    private val kuchenLiveData = MutableLiveData(initialKuchenList)

    fun getKuchenForId(id: Long): Rezept? {
        kuchenLiveData.value?.let { kuchen ->
            return kuchen.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getKuchenList(): LiveData<List<Rezept>> {
        return kuchenLiveData
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