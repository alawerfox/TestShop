package ru.kartyshova.testshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import ru.kartyshova.testshop.base.Navigator
import ru.kartyshova.testshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            loadKoinModules(module {
                single<Navigator> { NavigatorImpl(navController) }
            })
        }
    }
}