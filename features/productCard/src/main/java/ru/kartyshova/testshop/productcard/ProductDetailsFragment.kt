package ru.kartyshova.testshop.productcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kartyshova.testshop.base.Navigator
import ru.kartyshova.testshop.productcard.databinding.ProductDetailsBinding

class ProductDetailsFragment : Fragment() {

    lateinit var binding: ProductDetailsBinding
    private val shopList = ShopFragment.newInstance()
    private var bestSeller: ru.kartyshova.testshop.data.BestSeller? = null
    private val viewModel: ImageViewModel by viewModel()
    private val productDetailAdapter = ProductDetailAdapter()
    private val numberModel: NumberModel by activityViewModel()
    private val navigator: Navigator by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bestSeller = arguments?.getParcelable<ru.kartyshova.testshop.data.BestSeller>("arg")

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
                    bestSeller?.let { navigator.openCart(it) }
                }
                numberModel.cartNumber.observe(viewLifecycleOwner) {
                    binding.number.text = it
                }

            }

        }
    }
}




