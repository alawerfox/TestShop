package ru.kartyshova.testshop.domain

import ru.kartyshova.testshop.data.MainResponse
import ru.kartyshova.testshop.data.ProductCardResponse
import ru.kartyshova.testshop.data.ShopApi

class GetProductCardUseCase (
    private val shopApi: ShopApi
    ) {
        suspend operator fun invoke(): ProductCardResponse {
            return shopApi.getProductCard()
        }
    }