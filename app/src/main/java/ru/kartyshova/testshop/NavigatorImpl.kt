package ru.kartyshova.testshop

import androidx.navigation.NavController
import ru.kartyshova.testshop.base.Navigator
import ru.kartyshova.testshop.data.BestSeller
import ru.kartyshova.testshop.main.MainFragmentDirections
import ru.kartyshova.testshop.productcard.ProductDetailsFragmentDirections

class NavigatorImpl(private val navController: NavController) : Navigator {
    override fun openProductCard(bestSeller: BestSeller) {
        navController.navigate(MainFragmentDirections.actionMainFragmentToProductDetailsFragment(bestSeller))
    }

    override fun openCart(bestSeller: BestSeller) {
        navController.navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToCartFragment(bestSeller))
    }
}