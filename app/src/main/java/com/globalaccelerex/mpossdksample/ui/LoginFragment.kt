package com.globalaccelerex.mpossdksample.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.databinding.FragmentLoginBinding
import com.globalaccelerex.mpossdksample.ui.CatalogFragment.Companion.KEY_LOGIN


class LoginFragment : Fragment(R.layout.fragment_login) {

    private var fragmentLoginBinding: FragmentLoginBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding = FragmentLoginBinding.bind(view)

        val userLoggedInStateHandle = findNavController().previousBackStackEntry?.savedStateHandle
        userLoggedInStateHandle?.set(KEY_LOGIN, false)

        // Assign a click listener to take you to the catalog screen
        fragmentLoginBinding!!.buttonSignIn.setOnClickListener {
            // create an action from login screen to catalog screen
            userLoggedInStateHandle?.set(KEY_LOGIN, true)
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentLoginBinding = null
    }
}