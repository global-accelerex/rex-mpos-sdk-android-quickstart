package com.globalaccelerex.mpossdksample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.globalaccelerex.mpossdksample.databinding.CatalogListItemBinding
import com.globalaccelerex.mpossdksample.model.CatalogItem
import java.text.NumberFormat
import java.util.*

class CatalogItemAdapter(
    private val context: Context,
    private val dataset: List<CatalogItem>
) : RecyclerView.Adapter<CatalogItemAdapter.CatalogItemViewHolder>() {
    inner class CatalogItemViewHolder(private var binding: CatalogListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catalogItem: CatalogItem) {
            binding.catalogItemTitle.text =
                context.resources.getString(catalogItem.stringResourceTitle)
            binding.catalogItemPrice.text = NumberFormat.getCurrencyInstance(Locale("en", "NG"))
                .format(
                    context.resources.getString(catalogItem.stringResourcePrice).toDoubleOrNull()
                )
            binding.catalogItemImage.setImageResource(catalogItem.imageResourceId)
        }
    }


    override fun onBindViewHolder(holder: CatalogItemAdapter.CatalogItemViewHolder, position: Int) {
        val catalogItem = dataset[position]
        holder.bind(catalogItem)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder {
        return CatalogItemViewHolder(CatalogListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }
}