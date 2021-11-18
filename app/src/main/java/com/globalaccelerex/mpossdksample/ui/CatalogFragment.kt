package com.globalaccelerex.mpossdksample.ui

import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.adapter.CatalogItemAdapter
import com.globalaccelerex.mpossdksample.databinding.FragmentCatalogBinding
import com.globalaccelerex.mpossdksample.model.CatalogItem
import com.globalaccelerex.mpossdksample.viewModel.ItemViewModel
import com.globalaccelerex.mpossdksample.viewModel.ItemViewModelFactory


class CatalogFragment : Fragment(R.layout.fragment_catalog) {

    companion object {
        const val KEY_LOGIN = "key_login"
    }

    private var _fragmentCatalogBinding: FragmentCatalogBinding? = null
    private val fragmentCatalogBinding get() = _fragmentCatalogBinding!!

    private lateinit var adapter: CatalogItemAdapter

    private val viewModel: ItemViewModel by activityViewModels {
        ItemViewModelFactory(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _fragmentCatalogBinding = FragmentCatalogBinding.bind(view)

        adapter = CatalogItemAdapter(
            requireContext(),
            mutableListOf()
        ) { index ->

            // update item
            viewModel.updateItem(index)

        }

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
                val recyclerView = fragmentCatalogBinding.recyclerView
                fragmentCatalogBinding.recyclerView.adapter = adapter
                    viewModel.itemsList.observe(viewLifecycleOwner) { catalogItemList ->
                        adapter.setList(catalogItemList)
                }
                fragmentCatalogBinding.recyclerView.layoutManager =
                    LinearLayoutManager(requireContext())
                // for optimization since size is constant
                recyclerView.setHasFixedSize(true)

            }
        }
//        fragmentCatalogBinding.
        fragmentCatalogBinding.floatingActionButton.setOnClickListener {
            findNavController().navigate(CatalogFragmentDirections.actionCatalogFragmentToCheckoutFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentCatalogBinding = null
    }
}
