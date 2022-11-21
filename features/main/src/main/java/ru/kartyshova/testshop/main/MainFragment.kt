package ru.kartyshova.testshop.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kartyshova.testshop.base.Navigator
import ru.kartyshova.testshop.main.databinding.MainScreenBinding

class MainFragment: Fragment() {

    private val viewModel: ShopViewModel by viewModel()
    private val bestSellerAdapter = BestSellerAdapter()
    private val hotSalesAdapter = HotSalesAdapter()
    private val navigator: Navigator by inject()

    lateinit var binding: MainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.select1.setOnClickListener {
            it.isSelected = !it.isSelected
        }

        bestSellerAdapter.onClick = { bestSeller ->
            navigator.openProductCard(bestSeller)
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

        binding.bestSellerRv.apply {
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