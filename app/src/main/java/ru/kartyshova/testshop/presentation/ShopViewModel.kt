package ru.kartyshova.testshop.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.kartyshova.testshop.data.MainResponse
import ru.kartyshova.testshop.data.ShopApi
import ru.kartyshova.testshop.data.ShopApiServise

class ShopViewModel : ViewModel() {

    private val _status = MutableLiveData<MainResponse>()
    val status: LiveData<MainResponse> = _status

    init {
        getMain()
    }

    private fun getMain() {
        viewModelScope.launch {
            try {
                val listResult = ShopApiServise.retrofitService.getMain()
                _status.value = listResult
            } catch (e: Exception) {

            }
        }
    }
}