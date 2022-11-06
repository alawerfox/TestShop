package ru.kartyshova.testshop.data

data class HomeStore(
    val id: String,
    val title: String,
    val picture: String
)

data class BestSeller(
    val id: String,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Double,
    val discount_price: Double,
    val picture: String
)

data class MainResponse(
    val home_store: List<HomeStore>,
    val best_seller: List<BestSeller>
)

data class ProductCardResponse(
    val cpu: String,
    val camera: String,
    val capacity: Int,
    val color: String,
    val id: Int,
    val image: String,
    val isFavorites: Boolean,
    val  price: Double,
    val rating: Double,
    val title: String
)

data class CartsResponse(
    val basket: List<Basket>,
    val delivery: String,
    val id: Int,
    val total: Double
)

data class Basket(
    val id: String,
    val image: String,
    val price: Double,
    val title: String
)
