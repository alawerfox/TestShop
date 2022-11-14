package ru.kartyshova.testshop.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import ru.kartyshova.testshop.data.ShopApi
import ru.kartyshova.testshop.data.ShopViewModel

val dependency = module{
    viewModel{ ShopViewModel() }

    single<ShopApi> {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://run.mocky.io/v3/")
            .build()

        return@single retrofit.create(ShopApi::class.java)
    }

    viewModel { ShopViewModel() }

}