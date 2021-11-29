package com.globalaccelerex.mpossdksample.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.globalaccelerex.mpos.payment.*
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

    // Register the the payment result using activity results API
    private val cardPayment =
        registerForActivityResult(MposPayment.CardTransactionContract()) { result ->
            when (result.status) {
                TransactionStatus.APPROVED -> {
                    showCheckoutResult(result.responseData!!)
                }
                TransactionStatus.DECLINED -> {
                    val response = result.responseData!!
                    Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
                }

                TransactionStatus.FAILED,
                TransactionStatus.CANCELLED,
                TransactionStatus.TIMEOUT -> {
                    // Transaction failed Check the response message
                    Toast.makeText(requireContext(), result.responseMessage, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

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
            startCheckout()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentClothBinding = null
    }

    private fun showCheckoutResult(responseData: CardTransactionResponse) {
        // Show result
//        responseData.
        SweetAlertDialog(requireContext(), SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText("Success")
            .setContentText("Payment Verified").apply {
                setCancelable(false)
                show()
                confirmText = requireContext().resources.getString(R.string.dialog_ok)
                setConfirmClickListener {
                    findNavController().navigate(CheckoutFragmentDirections.actionCheckoutFragmentToCatalogFragment())
                    viewModel.clearSession()
                    dismissWithAnimation()
                }
            }

    }

    private fun startCheckout() {
        // Create a checkout request
//        val checkoutAmount = 2.0
        val request = PaymentRequest {
            requestType = RequestType.PURCHASE
//            amount = checkoutAmount
            amount = viewModel.totalPrice.value!!.toDouble()
            printReceipt = false
        }
        // Start the payment process
        cardPayment.launch(request)
    }
}