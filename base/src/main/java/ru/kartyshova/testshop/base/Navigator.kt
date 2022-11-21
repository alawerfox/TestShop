package ru.kartyshova.testshop.base

import ru.kartyshova.testshop.data.BestSeller

interface Navigator {
    fun openProductCard(bestSeller: BestSeller)
    fun openCart(bestSeller: BestSeller)
}