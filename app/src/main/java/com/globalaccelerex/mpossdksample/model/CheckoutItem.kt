package com.globalaccelerex.mpossdksample.model

import androidx.annotation.StringRes
import java.math.BigDecimal

data class CheckoutItem(
    @StringRes val stringResourceTitle: Int,
//    val totalSingularItemOrdered: Int,
//    val totalItemPrice: Double
    val itemPrice: BigDecimal,
    )