package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentClothDetailsBinding

class ClothDetailsFragment : Fragment(R.layout.fragment_cloth_details) {

    private var fragmentClothDetailsBinding: FragmentClothDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentClothDetailsBinding = null
    }
}