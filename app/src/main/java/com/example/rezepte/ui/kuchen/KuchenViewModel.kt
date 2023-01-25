package com.example.rezepte.ui.kuchen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KuchenViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Kuchen"
    }
    val text: LiveData<String> = _text
}