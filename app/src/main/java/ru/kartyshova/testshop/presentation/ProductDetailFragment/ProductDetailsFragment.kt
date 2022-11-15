package ru.kartyshova.testshop.presentation.ProductDetailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import ru.kartyshova.testshop.R
import ru.kartyshova.testshop.data.BestSeller
import ru.kartyshova.testshop.data.ImageViewModel
import ru.kartyshova.testshop.databinding.ProductDetailsBinding

class ProductDetailsFragment : Fragment() {

    lateinit var binding: ProductDetailsBinding
    private val shopList = ShopFragment.newInstance()
    private var bestSeller: BestSeller? = null
    private val viewModel: ImageViewModel by viewModels()
    private val productDetailAdapter = ProductDetailAdapter()
    private val numberModel: NumberModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bestSeller = arguments?.getParcelable<BestSeller>("arg")

        viewModel.status.observe(viewLifecycleOwner) {
            productDetailAdapter.image = it.images
            binding.productInfo.adapter = productDetailAdapter

        with(binding) {
            productDetailTitle.text = bestSeller?.title ?: ""

            productDetailsTabLayoyt.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    childFragmentManager.beginTransaction().replace(R.id.plaseHolder, shopList)
                        .commit()
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    childFragmentManager.beginTransaction().replace(R.id.plaseHolder, shopList)
                        .commit()
                }

            })
            val tab = productDetailsTabLayoyt.getTabAt(0)
            productDetailsTabLayoyt.selectTab(tab)

            btnCart.setOnClickListener {
                bestSeller?.let {
                    findNavController().navigate(
                        ProductDetailsFragmentDirections.actionProductDetailsFragmentToCartFragment(it))
                }
            }
            numberModel.cartNumber.observe(viewLifecycleOwner, {
                binding.number.text = it
            })

        }

    }
}
    }




