package ru.kartyshova.testshop.domain

import ru.kartyshova.testshop.data.MainResponse
import ru.kartyshova.testshop.data.ShopApi

class GetMainUseCase(
    private val shopApi: ShopApi
) {
    suspend operator fun invoke(): MainResponse {
        return shopApi.getMain()
    }
}