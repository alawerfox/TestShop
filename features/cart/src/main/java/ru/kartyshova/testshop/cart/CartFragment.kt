package ru.kartyshova.testshop.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.kartyshova.testshop.base.R

import ru.kartyshova.testshop.cart.databinding.CartBinding

class CartFragment : Fragment() {

    lateinit var binding: CartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bestSeller = arguments?.getParcelable<ru.kartyshova.testshop.data.BestSeller>("arg") ?: return

        with(binding) {
            titleCart.text = bestSeller.title
            titlePrice.text = bestSeller.price_without_discount.toString()
            Glide.with(requireContext()).load(bestSeller.picture).into(cartPicture)
            totalPrise.text = bestSeller.price_without_discount.toString()
            titlePrice.text = context?.getString(R.string.price_value, bestSeller.price_without_discount)
            totalPrise.text = context?.getString(R.string.price_value, bestSeller.price_without_discount)
    }
}
}