package com.example.rezepte.ui.salate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SalateViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Salate"
    }
    val text: LiveData<String> = _text
}