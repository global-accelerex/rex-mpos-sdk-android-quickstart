package com.globalaccelerex.mpossdksample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.databinding.CatalogListItemBinding
import com.globalaccelerex.mpossdksample.model.CatalogItem
import java.text.NumberFormat
import java.util.*

class CatalogItemAdapter(
    private val context: Context,
    private var dataset: List<CatalogItem>,
    private var onClick: (Int) -> Unit
) : RecyclerView.Adapter<CatalogItemAdapter.CatalogItemViewHolder>() {
    inner class CatalogItemViewHolder(
        private var binding: CatalogListItemBinding,
        val onClick: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var currentCatalogItem: CatalogItem

        fun bind(catalogItem: CatalogItem) {
            currentCatalogItem = catalogItem
            binding.catalogItemTitle.text =
                context.resources.getString(catalogItem.stringResourceTitle)
            binding.catalogItemPrice.text = NumberFormat.getCurrencyInstance(Locale("en", "NG"))
                .format(
                    context.resources.getString(catalogItem.stringResourcePrice).toBigDecimal()
                )
            binding.catalogItemImage.setImageResource(catalogItem.imageResourceId)
            if (catalogItem.isAdded) binding.addRemoveCart.text = context.resources.getString(R.string.remove)
            else binding.addRemoveCart.text = context.resources.getString(R.string.add)
            binding.addRemoveCart.setOnClickListener {
                // toggle text i.e if text is "Add" make text remove and vice versa

                onClick(bindingAdapterPosition)
                Log.i("CatalogItemAdapter", catalogItem.toString())

            }

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
        return CatalogItemViewHolder(
            CatalogListItemBinding.inflate(LayoutInflater.from(parent.context)),
            onClick
        )
    }

    fun setList(items: List<CatalogItem>) {
        this.dataset = items
        this.notifyDataSetChanged()
    }
}