package com.globalaccelerex.mpossdksample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.globalaccelerex.mpossdksample.databinding.CheckoutListItemBinding
import com.globalaccelerex.mpossdksample.model.CheckoutItem

class CheckoutListAdapter(
    private val context: Context
) : ListAdapter<CheckoutItem, CheckoutListAdapter.CheckoutViewHolder>(DiffCallback) {

    inner class CheckoutViewHolder(private var binding: CheckoutListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(checkoutItem: CheckoutItem) {
            binding.apply {
                itemContent.text = context.resources.getText(checkoutItem.stringResourceTitle)
//                quantityContent.text = checkoutItem.totalSingularItemOrdered.toString()
                priceContent.text = checkoutItem.itemPrice.toString()
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CheckoutItem>() {
        override fun areItemsTheSame(oldItem: CheckoutItem, newItem: CheckoutItem): Boolean {
            return oldItem.stringResourceTitle == newItem.stringResourceTitle
        }

        override fun areContentsTheSame(oldItem: CheckoutItem, newItem: CheckoutItem): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CheckoutViewHolder {
        return CheckoutViewHolder(CheckoutListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}