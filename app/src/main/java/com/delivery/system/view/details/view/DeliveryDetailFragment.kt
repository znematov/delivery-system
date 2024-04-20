package com.delivery.system.view.details.view

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.WindowManager
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.delivery.system.R

class DeliveryDetailFragment(private val address: String) : DialogFragment() {
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
        return inflater.inflate(R.layout.detail_button_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.DialogButton).setOnClickListener {
            dismiss()

        }
        view.findViewById<Button>(R.id.show_map_button).setOnClickListener {
            val map = "geo:0,0?q=$address"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(map))
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onStart() {
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        super.onStart()
    }
}