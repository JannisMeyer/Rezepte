package com.example.rezepte.ui.zusaetze

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ZusaetzeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Zusätze"
    }
    val text: LiveData<String> = _text
}