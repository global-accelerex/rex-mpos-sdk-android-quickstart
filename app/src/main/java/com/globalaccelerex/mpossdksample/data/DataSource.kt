package com.globalaccelerex.mpossdksample.data

import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.model.CatalogItem

object DataSource {
    fun loadCatalogListItems(): List<CatalogItem> {
        return listOf(
            // Clothes
            CatalogItem(
                R.string.adidas_sleeveless_outfit_black,
                R.drawable.adidas_sleeveless_outfit_black,
                R.string.point_one_naira
            ),
            CatalogItem(
                R.string.adidas_sleeveless_outfit_red,
                R.drawable.adidas_sleeveless_outfit_red,
                R.string.point_one_naira
            ),
            CatalogItem(
                R.string.adidas_sleeveless_outfit_white,
                R.drawable.adidas_sleeveless_outfit_white,
                R.string.point_one_naira
            ),

            CatalogItem(
                R.string.lacoste_sleeveless_outfit_red,
                R.drawable.lacoste_sleeveless_outfit_red,
                R.string.point_one_naira
            ),
            CatalogItem(
                R.string.lacoste_sleeveless_outfit_yellow,
                R.drawable.lacoste_sleeveless_outfit_yellow,
                R.string.point_one_naira
            ),
            CatalogItem(
                R.string.lacoste_sleeveless_outfit_white,
                R.drawable.lacoste_sleeveless_outfit_white,
                R.string.point_one_naira
            ),

            CatalogItem(
                R.string.vasace_outfit_black,
                R.drawable.versace_outfit_black,
                R.string.point_one_naira
            ),
            CatalogItem(
                R.string.vasace_outfit_red,
                R.drawable.versace_outfit_red,
                R.string.point_one_naira
            ),
            CatalogItem(
                R.string.versace_outfit_white,
                R.drawable.versace_outfit_white,
                R.string.point_one_naira
            ),

            // Shoes
            CatalogItem(
                R.string.asics_sneaker_one,
                R.drawable.asics_sneaker_one,
                R.string.point_two_naira
            ),
            CatalogItem(
                R.string.asics_sneaker_two,
                R.drawable.asics_sneaker_two,
                R.string.point_two_naira
            ),

            CatalogItem(
                R.string.caterpillar_boot,
                R.drawable.caterpillar_boot,
                R.string.point_two_naira
            ),

            CatalogItem(
                R.string.hilfiger_sneaker,
                R.drawable.hilfiger_sneaker,
                R.string.point_two_naira
            ),

            // Belts
            CatalogItem(
                R.string.box_leather_black,
                R.drawable.box_leather_black,
                R.string.point_one_naira
            ),
            CatalogItem(
                R.string.box_leather_black,
                R.drawable.box_leather_brown,
                R.string.point_one_naira
            ),

            CatalogItem(
                R.string.twisted_x_leather_brown,
                R.drawable.twisted_x_leather_brown,
                R.string.point_one_naira
            ),
            CatalogItem(
                R.string.twisted_x_leather_light_dark_brown,
                R.drawable.twisted_x_leather_light_dark_brown,
                R.string.point_one_naira
            ),

            // Watches
            CatalogItem(
                R.string.cartier_watch_black,
                R.drawable.cartier_watch_black,
                R.string.point_three_naira
            ),
            CatalogItem(
                R.string.cartier_watch_gold,
                R.drawable.cartier_watch_gold,
                R.string.point_three_naira
            ),

            CatalogItem(
                R.string.dw_watch_white,
                R.drawable.dw_watch_white,
                R.string.point_three_naira
            ),

            CatalogItem(
                R.string.fenix_watch,
                R.drawable.fenix_watch,
                R.string.point_three_naira
            ),

            CatalogItem(
                R.string.rodd_watch_brown,
                R.drawable.rodd_watch_brown,
                R.string.point_three_naira
            ),
            CatalogItem(
                R.string.rodd_watch_blue,
                R.drawable.rolex_blue,
                R.string.point_three_naira
            ),
            CatalogItem(
                R.string.rodd_watch_black,
                R.drawable.rodd_watch_black,
                R.string.point_three_naira
            )
            )
    }
}