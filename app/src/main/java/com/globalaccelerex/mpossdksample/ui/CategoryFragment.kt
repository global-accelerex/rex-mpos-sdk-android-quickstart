package com.globalaccelerex.mpossdksample.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.databinding.FragmentCategoryBinding


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