package com.example.rezepte.ui.hauptgerichte

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HauptgerichteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hauptgerichte"
    }
    val text: LiveData<String> = _text
}