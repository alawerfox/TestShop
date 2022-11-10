package ru.kartyshova.testshop.presentation.ProductDetailFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kartyshova.testshop.R

class ShopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shop_product_details, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = ShopFragment()

    }
}