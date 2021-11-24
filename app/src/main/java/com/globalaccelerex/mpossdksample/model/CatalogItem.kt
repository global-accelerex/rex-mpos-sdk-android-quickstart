package com.globalaccelerex.mpossdksample.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.math.BigDecimal

data class CatalogItem(
    @StringRes val stringResourceTitle: Int,
    @DrawableRes val imageResourceId: Int,
    val itemPrice: BigDecimal,
    var isAdded: Boolean = false
)
