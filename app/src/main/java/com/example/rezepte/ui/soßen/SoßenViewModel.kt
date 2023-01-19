package com.example.rezepte.ui.soßen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SoßenViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Soßen"
    }
    val text: LiveData<String> = _text
}