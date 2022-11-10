package ru.kartyshova.testshop.presentation.MainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import ru.kartyshova.testshop.databinding.MainScreenBinding
import ru.kartyshova.testshop.presentation.ShopViewModel

class MainFragment: Fragment() {

    private val viewModel: ShopViewModel by viewModels()
    private val bestSellerAdapter = BestSellerAdapter()

    lateinit var binding: MainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.status.observe(viewLifecycleOwner) {
            val hotSalesAdapter = HotSalesAdapter()
            hotSalesAdapter.homeStore = it.home_store
            bestSellerAdapter.bestSeller = it.best_seller
            with(binding){
                rvHotSales.adapter = hotSalesAdapter
                bestSellerRv.adapter = bestSellerAdapter
            }

        }

        binding?.bestSellerRv?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = bestSellerAdapter
        }

    }


}