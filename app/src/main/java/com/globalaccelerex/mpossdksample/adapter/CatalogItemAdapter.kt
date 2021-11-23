package com.globalaccelerex.mpossdksample.adapter

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.databinding.CatalogListItemBinding
import com.globalaccelerex.mpossdksample.model.CatalogItem
import java.text.NumberFormat
import java.util.*

class CatalogItemAdapter(
    private var onClick: (Int) -> Unit
) : ListAdapter<CatalogItem, CatalogItemAdapter.CatalogItemViewHolder>(CatalogDiffCallback) {
    inner class CatalogItemViewHolder(
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
                    resources.getString(catalogItem.stringResourcePrice).toBigDecimal()
                )
            binding.catalogItemImage.setImageResource(catalogItem.imageResourceId)
            if (catalogItem.isAdded) binding.addRemoveCart.text = resources.getString(R.string.remove)
            else binding.addRemoveCart.text = resources.getString(R.string.add)
            binding.addRemoveCart.setOnClickListener {
                // toggle text i.e if text is "Add" make text remove and vice versa

                onClick(bindingAdapterPosition)
                Log.i("CatalogItemAdapter", catalogItem.toString())

            }

        }
    }


    override fun onBindViewHolder(holder: CatalogItemAdapter.CatalogItemViewHolder, position: Int) {
        val catalogItem = getItem(position)
        holder.bind(catalogItem)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder {
        return CatalogItemViewHolder(
            CatalogListItemBinding.inflate(LayoutInflater.from(parent.context)),
            onClick
        )
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