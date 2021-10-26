package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentClothBinding

class ClothFragment : Fragment(R.layout.fragment_cloth) {
    private var fragmentClothBinding: FragmentClothBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentClothBinding.bind(view)
        fragmentClothBinding = binding
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentClothBinding = null
    }
}