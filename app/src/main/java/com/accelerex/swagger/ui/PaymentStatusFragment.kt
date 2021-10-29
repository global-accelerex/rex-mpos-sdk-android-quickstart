package com.accelerex.swagger.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.accelerex.swagger.R
import com.accelerex.swagger.databinding.FragmentPaymentStatusBinding

class PaymentStatusFragment : Fragment(R.layout.fragment_payment_status) {

    private var fragmentPaymentStatusBinding: FragmentPaymentStatusBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentPaymentStatusBinding = FragmentPaymentStatusBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentPaymentStatusBinding = null
    }
}