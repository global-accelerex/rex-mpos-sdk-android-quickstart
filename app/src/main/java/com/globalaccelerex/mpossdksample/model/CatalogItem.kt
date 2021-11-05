package com.globalaccelerex.mpossdksample.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CatalogItem(
    @StringRes val stringResourceTitle: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringResourcePrice: Int
)
