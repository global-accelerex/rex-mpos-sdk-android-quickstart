package com.accelerex.swagger.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.accelerex.swagger.R
import com.accelerex.swagger.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {

    private var fragmentLoginBinding: FragmentLoginBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding = FragmentLoginBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentLoginBinding = null
    }
}