package com.juri.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.juri.home.databinding.ProductListItemBinding
import com.juri.home.domain.DomainProduct

class StoreAdapter : ListAdapter<DomainProduct, StoreAdapter.StoreViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    class StoreViewHolder private constructor(private var binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: DomainProduct) {
            binding.productName.text = product.title
            binding.productPrice.text = "$${product.price}"
            binding.ratingBar.rating = product.rating.toFloat()
        }

        companion object {
            fun from(parent: ViewGroup): StoreViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ProductListItemBinding.inflate(layoutInflater)
                return StoreViewHolder(binding)
            }
        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<DomainProduct>() {
        override fun areItemsTheSame(oldItem: DomainProduct, newItem: DomainProduct): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DomainProduct, newItem: DomainProduct): Boolean {
            return oldItem.id == newItem.id
        }

    }
}