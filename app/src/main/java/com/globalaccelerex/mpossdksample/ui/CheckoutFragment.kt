package com.globalaccelerex.mpossdksample.ui

import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.adapter.CheckoutListAdapter
import com.globalaccelerex.mpossdksample.databinding.FragmentCheckoutBinding
import com.globalaccelerex.mpossdksample.viewModel.ItemViewModel
import timber.log.Timber
import java.text.NumberFormat
import java.util.*

class CheckoutFragment : Fragment(R.layout.fragment_checkout) {
    private var _fragmentClothBinding: FragmentCheckoutBinding? = null
    private val fragmentClothBinding get() = _fragmentClothBinding!!

    private val viewModel: ItemViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _fragmentClothBinding = FragmentCheckoutBinding.bind(view)
        val adapter = CheckoutListAdapter()

        fragmentClothBinding.recyclerView.adapter = adapter
        viewModel.selectedItemList.observe(viewLifecycleOwner) {
            Timber.i(it.toString())
            adapter.submitList(it)
        }
        fragmentClothBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // observe Total price in Checkout screen
        viewModel.totalPrice.observe(viewLifecycleOwner) {
            fragmentClothBinding.realTotal.text =
                NumberFormat.getCurrencyInstance(Locale("en", "NG")).format(it)
        }
        fragmentClothBinding.payButton.setOnClickListener {
            SweetAlertDialog(requireContext(), SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Success")
                .setContentText("Payment Verified").apply {
                    setCancelable(false)
                    show()
                    confirmText = requireContext().resources.getString(R.string.dialog_ok)
                    setConfirmClickListener {
//                        findNavController().navigate(R.id.parent)
                        finishAffinity(requireActivity())
                    }
                }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentClothBinding = null
    }
}