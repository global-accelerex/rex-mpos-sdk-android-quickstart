package com.globalaccelerex.mpossdksample.ui

import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.adapter.CatalogItemAdapter
import com.globalaccelerex.mpossdksample.data.DataSource
import com.globalaccelerex.mpossdksample.databinding.FragmentCatalogBinding


class CatalogFragment : Fragment(R.layout.fragment_catalog) {

    companion object {
        const val KEY_LOGIN = "key_login"
    }

    private var _fragmentCatalogBinding: FragmentCatalogBinding? = null
    private val fragmentCatalogBinding get() = _fragmentCatalogBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _fragmentCatalogBinding = FragmentCatalogBinding.bind(view)

        val userLoggedInStateHandle = findNavController().currentBackStackEntry?.savedStateHandle

        when (userLoggedInStateHandle?.get<Boolean>(KEY_LOGIN)) {
            null -> {
                findNavController().navigate(CatalogFragmentDirections.actionCatalogFragmentToLoginFragment())
            }
            false -> {
                finishAffinity(requireActivity())
            }
            true -> {
                // Initialize data.
                val catalogItemDataSet = DataSource.loadCatalogListItems()

                val recyclerView = fragmentCatalogBinding.recyclerView
                val catalogItemAdapter = CatalogItemAdapter(requireContext(), catalogItemDataSet)
                fragmentCatalogBinding.recyclerView.adapter = catalogItemAdapter

                // for optimization since size is constant
                recyclerView.setHasFixedSize(true)

            }
        }
        fragmentCatalogBinding.floatingActionButton.setOnClickListener {
            findNavController().navigate(CatalogFragmentDirections.actionCatalogFragmentToCheckoutFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentCatalogBinding = null
    }
}
