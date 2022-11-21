package ru.kartyshova.testshop.domain.di

import org.koin.dsl.module
import ru.kartyshova.testshop.domain.GetMainUseCase
import ru.kartyshova.testshop.domain.GetProductCardUseCase

val domainModule = module {
    single { GetMainUseCase(get()) }
    single { GetProductCardUseCase(get()) }
}