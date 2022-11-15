package ru.kartyshova.testshop.presentation.MainFragment

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.kartyshova.testshop.R
import ru.kartyshova.testshop.data.BestSeller
import ru.kartyshova.testshop.databinding.BestSellerBinding

class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.BestSellerHolder>() {

    var bestSeller = listOf<BestSeller>()

    var onClick: (BestSeller) -> Unit = {}

    class BestSellerHolder(private val binding: BestSellerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bestSeller: BestSeller, onClick: (BestSeller) -> Unit) = with(binding) {
            val context = binding.root.context
            price.text = context.getString(R.string.price_value, bestSeller.price_without_discount)
            discountPrice.text = Html.fromHtml(context.getString(R.string.strike_text, bestSeller.discount_price.toString()))
            description.text = bestSeller.title
            like.setOnClickListener { it.isSelected = !it.isSelected }
            Glide.with(pictureBestSeller).load(bestSeller.picture).into(pictureBestSeller)

            root.setOnClickListener {
                onClick(bestSeller)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerHolder {
        val binding = BestSellerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BestSellerHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerHolder, position: Int) {
        val item = bestSeller[position]
        holder.bind(item, onClick)
    }

    override fun getItemCount(): Int {
        return bestSeller.size
    }

}