package com.accelerex.swagger.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.accelerex.swagger.R
import com.accelerex.swagger.databinding.FragmentClothDetailsBinding

class ClothDetailsFragment : Fragment(R.layout.fragment_cloth_details) {

    private var fragmentClothDetailsBinding: FragmentClothDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentClothDetailsBinding = FragmentClothDetailsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentClothDetailsBinding = null
    }
}