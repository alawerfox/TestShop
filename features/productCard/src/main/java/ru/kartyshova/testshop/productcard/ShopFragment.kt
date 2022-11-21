package ru.kartyshova.testshop.productcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import ru.kartyshova.testshop.productcard.databinding.ShopProductDetailsBinding

class ShopFragment : Fragment() {

    private val numberModel: NumberModel by activityViewModel()
    lateinit var binding: ShopProductDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ShopProductDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var i = 1
        binding.addToCartBtn.setOnClickListener {
          numberModel.cartNumber.value = i++.toString()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ShopFragment()

    }
}
