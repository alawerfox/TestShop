package ru.kartyshova.testshop.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ImageViewModel: ViewModel() {

    private val _status = MutableLiveData<ProductCardResponse>()
    val status: LiveData<ProductCardResponse> = _status

    init {
        getProductCard()
    }

    private fun getProductCard() {
        viewModelScope.launch {
            try {
                val listResult = ShopApiServise.retrofitService.getProductCard()
                _status.value = listResult
            } catch (e: Exception) {
                Log.e("Tete", "Error", e)
            }
        }
    }
}