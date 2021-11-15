package com.globalaccelerex.mpossdksample.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ItemViewModel : ViewModel(){
//    private val _totalSingularItemOrdered = MutableLiveData(0)
//    private val totalSingularItemOrdered get() = _totalSingularItemOrdered

//    private val _totalItemsOrdered = MutableLiveData(0)
//    private val totalItemsOrdered get() = _totalItemsOrdered

    private val _totalSingularItemPrice = MutableLiveData(0)
    private val totalSingularItemPrice get() = _totalSingularItemPrice

    private val _totalPrice = MutableLiveData(0)
    private val totalPrice get() = _totalPrice

//    fun decrementSingularItemOrdered(){
//        _totalSingularItemOrdered.value = _totalSingularItemOrdered.value?.dec()
//    }

//    fun incrementSingularItemOrdered(){
//        _totalSingularItemOrdered.value = _totalSingularItemOrdered.value?.inc()
//    }

}