package com.globalaccelerex.mpossdksample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.globalaccelerex.mpossdksample.data.DataSource.loadCatalogListItems
import com.globalaccelerex.mpossdksample.model.CatalogItem
import com.globalaccelerex.mpossdksample.model.CheckoutItem
import timber.log.Timber
import java.math.BigDecimal


class ItemViewModel : ViewModel() {
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
            CheckoutItem(it.stringResourceTitle, it.itemPrice)
        }
    }

    private val _totalPrice = Transformations.map(selectedItemList) { checkOutItemList ->
        checkOutItemList.sumOf { it.itemPrice }
    } as MutableLiveData<BigDecimal>
    val totalPrice: LiveData<BigDecimal>
        get() = _totalPrice

    init {
        _itemsList.value = loadCatalogListItems()
        Timber.i(itemsList.value.toString())
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

    fun clearSession() {
        _itemsList.value = loadCatalogListItems()
        _totalPrice.value = BigDecimal.valueOf(0)
    }
}
