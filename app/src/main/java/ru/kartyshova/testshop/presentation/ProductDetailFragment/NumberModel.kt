package ru.kartyshova.testshop.presentation.ProductDetailFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class NumberModel :ViewModel() {
    val cartNumber: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }
}