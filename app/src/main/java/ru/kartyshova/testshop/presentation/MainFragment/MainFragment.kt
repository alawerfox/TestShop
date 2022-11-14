package ru.kartyshova.testshop.presentation.MainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import ru.kartyshova.testshop.R
import ru.kartyshova.testshop.databinding.MainScreenBinding
import ru.kartyshova.testshop.data.ShopViewModel

class MainFragment: Fragment() {

    private val viewModel: ShopViewModel by viewModels()
    private val bestSellerAdapter = BestSellerAdapter()
    private val hotSalesAdapter = HotSalesAdapter()

    lateinit var binding: MainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bestSellerAdapter.onClick = { bestSeller ->
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToProductDetailsFragment(bestSeller))
        }

        viewModel.status.observe(viewLifecycleOwner) {
            hotSalesAdapter.homeStore = it.home_store
            bestSellerAdapter.bestSeller = it.best_seller
            with(binding){
                rvHotSales.adapter = hotSalesAdapter
                bestSellerRv.adapter = bestSellerAdapter
                filter.setOnClickListener { (showFilter()) }
            }

        }

        binding?.bestSellerRv?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = bestSellerAdapter
        }


    }

    private fun showFilter(){
        val filter = BottomSheetDialog(requireContext())
        filter.setContentView(R.layout.filter)
        filter.show()
    }


}