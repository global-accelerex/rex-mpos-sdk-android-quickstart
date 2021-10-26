package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment(R.layout.fragment_category) {

    private var fragmentCategoryBinding: FragmentCategoryBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCategoryBinding.bind(view)
        fragmentCategoryBinding = binding
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentCategoryBinding = null
    }
}