package com.accelerex.swagger.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.accelerex.swagger.R
import com.accelerex.swagger.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment(R.layout.fragment_category) {

    private var fragmentCategoryBinding: FragmentCategoryBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCategoryBinding = FragmentCategoryBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentCategoryBinding = null
    }
}