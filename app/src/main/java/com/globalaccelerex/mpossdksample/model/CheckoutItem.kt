package com.globalaccelerex.mpossdksample.model

import androidx.annotation.StringRes

data class CheckoutItem(
    @StringRes val stringResourceTitle: Int,
//    val totalSingularItemOrdered: Int,
//    val totalItemPrice: Double
    val itemPrice: Double
    )