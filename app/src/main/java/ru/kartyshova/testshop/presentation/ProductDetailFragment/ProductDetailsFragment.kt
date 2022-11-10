package ru.kartyshova.testshop.presentation.ProductDetailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
import ru.kartyshova.testshop.R
import ru.kartyshova.testshop.databinding.MainScreenBinding
import ru.kartyshova.testshop.databinding.ProductDetailsBinding

class ProductDetailsFragment: Fragment() {

    lateinit var binding: ProductDetailsBinding
    private val shopList = ShopFragment.newInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductDetailsBinding.inflate(inflater)
        return binding.root

        binding.productDetailsTabLayoyt.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                childFragmentManager.
                beginTransaction().
                replace(R.id.plaseHolder,shopList).commit()
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            }

        }




