package ru.kartyshova.testshop.productcard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.kartyshova.testshop.data.ProductCardResponse
import ru.kartyshova.testshop.domain.GetProductCardUseCase

class ImageViewModel(
    private val getProductCardUseCase: GetProductCardUseCase
): ViewModel() {

    private val _status = MutableLiveData<ProductCardResponse>()
    val status: LiveData<ProductCardResponse> = _status

    init {
        getProductCard()
    }

    private fun getProductCard() {
        viewModelScope.launch {
            try {
                val listResult = getProductCardUseCase()
                _status.value = listResult
            } catch (e: Exception) {
                Log.e("Tete", "Error", e)
            }
        }
    }
}