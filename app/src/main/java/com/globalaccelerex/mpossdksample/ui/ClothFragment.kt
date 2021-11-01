package com.globalaccelerex.mpossdksample.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.databinding.FragmentClothBinding

class ClothFragment : Fragment(R.layout.fragment_cloth) {
    private var fragmentClothBinding: FragmentClothBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentClothBinding = FragmentClothBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentClothBinding = null
    }
}