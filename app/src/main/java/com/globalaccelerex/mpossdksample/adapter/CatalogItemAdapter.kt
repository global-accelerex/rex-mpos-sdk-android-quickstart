package com.globalaccelerex.mpossdksample.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.databinding.CatalogListItemBinding
import com.globalaccelerex.mpossdksample.model.CatalogItem
import java.text.NumberFormat
import java.util.*

class CatalogItemAdapter(
    private var onClick: (Int) -> Unit
) : ListAdapter<CatalogItem, CatalogItemAdapter.CatalogItemViewHolder>(CatalogDiffCallback) {
    class CatalogItemViewHolder private constructor(
        private var binding: CatalogListItemBinding,
        val onClick: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        private val resources: Resources = binding.root.context.resources

        fun bind(catalogItem: CatalogItem) {
            binding.catalogItemTitle.text =
                resources.getString(catalogItem.stringResourceTitle)
            binding.catalogItemPrice.text = NumberFormat.getCurrencyInstance(Locale("en", "NG"))
                .format(
                    catalogItem.itemPrice
                )
            binding.catalogItemImage.load(catalogItem.imageResourceId) {
                crossfade(true)
            }
            isAdded(catalogItem)
            binding.addRemoveCart.setOnClickListener {

                onClick(bindingAdapterPosition)
                isAdded(catalogItem)
            }

        }

        private fun isAdded(catalogItem: CatalogItem) {
            if (catalogItem.isAdded) binding.addRemoveCart.text =
                resources.getString(R.string.remove)
            else binding.addRemoveCart.text = resources.getString(R.string.add)
        }

        companion object {
            fun from(parent: ViewGroup, onClick: (Int) -> Unit): CatalogItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CatalogListItemBinding.inflate(layoutInflater, parent, false)
                return CatalogItemViewHolder(binding, onClick)
            }
        }

    }


    override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
        val catalogItem = getItem(position)
        holder.bind(catalogItem)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder {
        return CatalogItemViewHolder.from(parent, onClick)
    }

    companion object CatalogDiffCallback: DiffUtil.ItemCallback<CatalogItem>() {
        override fun areItemsTheSame(oldItem: CatalogItem, newItem: CatalogItem): Boolean {
            return oldItem.stringResourceTitle == newItem.stringResourceTitle
        }

        override fun areContentsTheSame(oldItem: CatalogItem, newItem: CatalogItem): Boolean {
            return oldItem == newItem
        }

    }
}