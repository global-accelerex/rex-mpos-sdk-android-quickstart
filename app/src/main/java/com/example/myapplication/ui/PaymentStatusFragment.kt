package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPaymentStatusBinding

class PaymentStatusFragment : Fragment(R.layout.fragment_payment_status) {

    private var fragmentPaymentStatusBinding: FragmentPaymentStatusBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPaymentStatusBinding.bind(view)
        fragmentPaymentStatusBinding = binding
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentPaymentStatusBinding = null
    }
}