package com.globalaccelerex.mpossdksample.data

import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.model.CatalogItem
import java.math.BigDecimal

object DataSource {
    private val pointOneNaira : BigDecimal = BigDecimal.valueOf(0.1)
    private val pointTwoNaira : BigDecimal = BigDecimal.valueOf(0.2)
    private val pointThreeNaira : BigDecimal = BigDecimal.valueOf(0.3)
    fun loadCatalogListItems(): MutableList<CatalogItem> {
        return mutableListOf(
            // Clothes
            CatalogItem(
                R.string.adidas_sleeveless_outfit_black,
                R.drawable.adidas_sleeveless_outfit_black,
                pointOneNaira
            ),
            CatalogItem(
                R.string.adidas_sleeveless_outfit_red,
                R.drawable.adidas_sleeveless_outfit_red,
                pointOneNaira
            ),
            CatalogItem(
                R.string.adidas_sleeveless_outfit_white,
                R.drawable.adidas_sleeveless_outfit_white,
                pointOneNaira
            ),

            CatalogItem(
                R.string.lacoste_sleeveless_outfit_red,
                R.drawable.lacoste_sleeveless_outfit_red,
                pointOneNaira
            ),
            CatalogItem(
                R.string.lacoste_sleeveless_outfit_yellow,
                R.drawable.lacoste_sleeveless_outfit_yellow,
                pointOneNaira
            ),
            CatalogItem(
                R.string.lacoste_sleeveless_outfit_white,
                R.drawable.lacoste_sleeveless_outfit_white,
                pointOneNaira
            ),

            CatalogItem(
                R.string.vasace_outfit_black,
                R.drawable.versace_outfit_black,
                pointOneNaira
            ),
            CatalogItem(
                R.string.vasace_outfit_red,
                R.drawable.versace_outfit_red,
                pointOneNaira
            ),
            CatalogItem(
                R.string.versace_outfit_white,
                R.drawable.versace_outfit_white,
                pointOneNaira
            ),

            // Shoes
            CatalogItem(
                R.string.asics_sneaker_one,
                R.drawable.asics_sneaker_one,
                pointTwoNaira
            ),
            CatalogItem(
                R.string.asics_sneaker_two,
                R.drawable.asics_sneaker_two,
                pointTwoNaira
            ),

            CatalogItem(
                R.string.caterpillar_boot,
                R.drawable.caterpillar_boot,
                pointTwoNaira
            ),

            CatalogItem(
                R.string.hilfiger_sneaker,
                R.drawable.hilfiger_sneaker,
                pointTwoNaira
            ),

            // Belts
            CatalogItem(
                R.string.box_leather_black,
                R.drawable.box_leather_black,
                pointOneNaira
            ),
            CatalogItem(
                R.string.box_leather_black,
                R.drawable.box_leather_brown,
                pointOneNaira
            ),

            CatalogItem(
                R.string.twisted_x_leather_brown,
                R.drawable.twisted_x_leather_brown,
                pointOneNaira
            ),
            CatalogItem(
                R.string.twisted_x_leather_light_dark_brown,
                R.drawable.twisted_x_leather_light_dark_brown,
                pointOneNaira
            ),

            // Watches
            CatalogItem(
                R.string.cartier_watch_black,
                R.drawable.cartier_watch_black,
                pointThreeNaira
            ),
            CatalogItem(
                R.string.cartier_watch_gold,
                R.drawable.cartier_watch_gold,
                pointThreeNaira
            ),

            CatalogItem(
                R.string.dw_watch_white,
                R.drawable.dw_watch_white,
                pointThreeNaira
            ),

            CatalogItem(
                R.string.fenix_watch,
                R.drawable.fenix_watch,
                pointThreeNaira
            ),

            CatalogItem(
                R.string.rodd_watch_brown,
                R.drawable.rodd_watch_brown,
                pointThreeNaira
            ),
            CatalogItem(
                R.string.rodd_watch_blue,
                R.drawable.rolex_blue,
                pointThreeNaira
            ),
            CatalogItem(
                R.string.rodd_watch_black,
                R.drawable.rodd_watch_black,
                pointThreeNaira
            )
            )
    }
}