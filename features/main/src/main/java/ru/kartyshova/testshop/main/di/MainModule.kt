package ru.kartyshova.testshop.main.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kartyshova.testshop.main.ShopViewModel

val mainModule = module {
    viewModel {
        ShopViewModel(get())
    }
}