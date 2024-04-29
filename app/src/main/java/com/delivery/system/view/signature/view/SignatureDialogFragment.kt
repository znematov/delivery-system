package com.delivery.system.view.signature.view

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.delivery.system.R
import com.delivery.system.view.home.vm.HomeViewModel

class SignatureDialogFragment(private val orderId: String) : DialogFragment() {
    private val viewModel by lazy(LazyThreadSafetyMode.NONE){
        ViewModelProvider(requireParentFragment())[HomeViewModel::class.java]
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCancelable(false)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.drawingview_dialog_fragment,
            container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.back_to_delivery_button).setOnClickListener {
            dismiss()
        }
        view.findViewById<Button>(R.id.accept_signature_button).setOnClickListener {
            val drawingView = view.findViewById<DrawingView>(R.id.drawing_view)
            if (drawingView.extraBitmap.byteCount > 0){
                viewModel.completeOrder(orderId)
                dismiss()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onStart() {
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        super.onStart()
    }
}