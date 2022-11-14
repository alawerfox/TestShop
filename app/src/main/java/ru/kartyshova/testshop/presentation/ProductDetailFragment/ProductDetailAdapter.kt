package ru.kartyshova.testshop.presentation.ProductDetailFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.kartyshova.testshop.databinding.ProductDetailImageBinding

class ProductDetailAdapter : RecyclerView.Adapter<ProductDetailAdapter.ProductDetailImageHolder>() {

    var image = listOf<String>()


    class ProductDetailImageHolder(private val binding: ProductDetailImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) = with(binding) {
            Glide.with(productDetailImage).load(image).into(productDetailImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailImageHolder {
        val binding = ProductDetailImageBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductDetailImageHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductDetailImageHolder, position: Int) {
        val item = image[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return image.size
    }

}