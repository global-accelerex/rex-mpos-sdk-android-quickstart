package com.globalaccelerex.mpossdksample.adapter

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.globalaccelerex.mpossdksample.databinding.CheckoutListItemBinding
import com.globalaccelerex.mpossdksample.model.CheckoutItem
import java.text.NumberFormat
import java.util.*

class CheckoutListAdapter :
    ListAdapter<CheckoutItem, CheckoutListAdapter.CheckoutViewHolder>(DiffCallback) {

    class CheckoutViewHolder private constructor(private var binding: CheckoutListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val resources: Resources = binding.root.context.resources

        fun bind(checkoutItem: CheckoutItem) {
            binding.itemContent.text = resources.getText(checkoutItem.stringResourceTitle)
//                quantityContent.text = checkoutItem.totalSingularItemOrdered.toString()
            binding.priceContent.text = NumberFormat.getCurrencyInstance(Locale("en", "NG"))
                .format(checkoutItem.itemPrice)
            Log.d("CheckoutListAdapter", binding.priceContent.text.toString())
        }

        companion object {
            fun from(parent: ViewGroup): CheckoutViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = CheckoutListItemBinding.inflate(layoutInflater, parent, false)

                return CheckoutViewHolder(view)
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
        return CheckoutViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}