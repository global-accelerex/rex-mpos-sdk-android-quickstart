package com.globalaccelerex.mpossdksample.ui

import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.globalaccelerex.mpossdksample.R
import com.globalaccelerex.mpossdksample.databinding.FragmentCheckoutBinding

class CheckoutFragment : Fragment(R.layout.fragment_checkout) {
    private var _fragmentClothBinding: FragmentCheckoutBinding? = null
    private val fragmentClothBinding get() = _fragmentClothBinding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _fragmentClothBinding = FragmentCheckoutBinding.bind(view)
        fragmentClothBinding.payButton.setOnClickListener {
            SweetAlertDialog(requireContext(), SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Success")
                .setContentText("Payment Verified").apply {
                    show()
                    confirmText = requireContext().resources.getString(R.string.dialog_ok)
                    setConfirmClickListener {
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