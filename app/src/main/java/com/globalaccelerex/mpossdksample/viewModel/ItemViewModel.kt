package com.globalaccelerex.mpossdksample.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.globalaccelerex.mpossdksample.data.DataSource.loadCatalogListItems
import com.globalaccelerex.mpossdksample.model.CatalogItem
import com.globalaccelerex.mpossdksample.model.CheckoutItem


class ItemViewModel(context: Context) : ViewModel() {
    // List of all catalog items
    private val _itemsList = MutableLiveData<MutableList<CatalogItem>>()
    val itemsList: LiveData<MutableList<CatalogItem>>  get() = _itemsList

    // List of all CheckOut Items
    val selectedItemList = Transformations.map(itemsList) { catalogItemList ->
        // Filter out items not added to cart
        catalogItemList.filter {
            it.isAdded
        }.map {
            // Map the added Catalog Items to Checkout Items
            CheckoutItem(it.stringResourceTitle, it.stringResourcePrice)
        }
    }

    val totalPrice = Transformations.map(selectedItemList) { checkOutItemList ->
        checkOutItemList.sumOf { (context.resources.getString(it.stringResourcePrice)).toBigDecimal() }
    }

    init {
        _itemsList.value = loadCatalogListItems()
        Log.i("catalogItemList", itemsList.value.toString())
    }

    fun updateItem(index: Int) {
        // get the item
        val item = _itemsList.value!![index]

        // change current state
        item.isAdded = !item.isAdded

        // add it back to the list

        // get the list
        val list = _itemsList.value!!

        // set the modified item into the list at the index you got it before.
        list[index] = item

        _itemsList.postValue(list)

    }
}

class ItemViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}