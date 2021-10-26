package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {

    private var fragmentLoginBinding: FragmentLoginBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // why not just inline binding
        val binding = FragmentLoginBinding.bind(view)
        fragmentLoginBinding = binding
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentLoginBinding = null
    }
}