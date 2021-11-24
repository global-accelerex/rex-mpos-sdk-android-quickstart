package com.globalaccelerex.mpossdksample.adapter

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.model.CheckoutItem
import java.text.NumberFormat
import java.util.*

class CheckoutListAdapter(
) : ListAdapter<CheckoutItem, CheckoutListAdapter.CheckoutViewHolder>(DiffCallback) {

    class CheckoutViewHolder private constructor(view: View) :
//    inner class CheckoutViewHolder(private var binding: CheckoutListItemBinding) :
        RecyclerView.ViewHolder(view) {
        private val resources: Resources = view.context.resources
        private val item: TextView = view.findViewById(R.id.item_content)
        private val price: TextView = view.findViewById(R.id.price_content)

        fun bind(checkoutItem: CheckoutItem) {
//            binding.apply {
            item.text = resources.getText(checkoutItem.stringResourceTitle)
//                quantityContent.text = checkoutItem.totalSingularItemOrdered.toString()
            price.text = NumberFormat.getCurrencyInstance(Locale("en", "NG"))
                .format(checkoutItem.itemPrice)
            Log.d("CheckoutListAdapter", price.text.toString())
//            }
        }
        companion object{
            fun from(parent: ViewGroup): CheckoutViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.checkout_list_item, parent, false)
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
    ): CheckoutListAdapter.CheckoutViewHolder {
//        return CheckoutViewHolder(CheckoutListItemBinding.inflate(LayoutInflater.from(parent.context)))
        return CheckoutViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}