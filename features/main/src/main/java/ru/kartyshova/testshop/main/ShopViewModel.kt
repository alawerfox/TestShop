package ru.kartyshova.testshop.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.kartyshova.testshop.data.MainResponse
import ru.kartyshova.testshop.domain.GetMainUseCase

class ShopViewModel(
    private val getMainUseCase: GetMainUseCase
) : ViewModel() {

    private val _status = MutableLiveData<MainResponse>()
    val status: LiveData<MainResponse> = _status

    init {
        getMain()
    }

    private fun getMain() {
        viewModelScope.launch {
            try {
                val listResult = getMainUseCase()
                _status.value = listResult
            } catch (e: Exception) {
                Log.e("Tete", "Error", e)
            }
        }
    }
}