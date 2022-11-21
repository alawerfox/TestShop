package ru.kartyshova.testshop.productcard.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kartyshova.testshop.productcard.ImageViewModel
import ru.kartyshova.testshop.productcard.NumberModel

val productCardModule = module {
    viewModel {
        ImageViewModel(get())
    }
    viewModel {
        NumberModel()
    }
}