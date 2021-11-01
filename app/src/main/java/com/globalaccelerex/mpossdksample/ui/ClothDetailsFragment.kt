package com.globalaccelerex.mpossdksample.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.databinding.FragmentClothDetailsBinding

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