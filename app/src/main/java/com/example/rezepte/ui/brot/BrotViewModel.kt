package com.example.rezepte.ui.brot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BrotViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Brot"
    }
    val text: LiveData<String> = _text
}