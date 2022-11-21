package ru.kartyshova.testshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.kartyshova.testshop.data.di.dataModule
import ru.kartyshova.testshop.domain.di.domainModule
import ru.kartyshova.testshop.main.di.mainModule
import ru.kartyshova.testshop.productcard.di.productCardModule


class StartActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@StartActivity.applicationContext)
            modules(
                dataModule,
                domainModule,
                mainModule,
                productCardModule
            )
        }

        handler.postDelayed({
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finishActivity(RESULT_OK)
        }, 200L)
    }
}