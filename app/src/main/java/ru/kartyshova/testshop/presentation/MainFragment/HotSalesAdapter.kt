package ru.kartyshova.testshop.presentation.MainFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.kartyshova.testshop.data.HomeStore
import ru.kartyshova.testshop.databinding.HotSalesBinding


class HotSalesAdapter : RecyclerView.Adapter<HotSalesAdapter.HotSalesHolder>() {

    var homeStore = listOf<HomeStore>()

    class HotSalesHolder(private val binding: HotSalesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(homeStore: HomeStore) = with(binding) {
            title.text = homeStore.title
            Glide.with(picture)
                .load(homeStore.picture)
                .transform(CenterCrop(), RoundedCorners(24))
                .into(picture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesHolder {
        val binding = HotSalesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HotSalesHolder(binding)
    }

    override fun onBindViewHolder(holder: HotSalesHolder, position: Int) {
        val item = homeStore[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return homeStore.size
    }
}