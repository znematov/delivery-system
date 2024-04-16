package com.delivery.system.core.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.delivery.system.R

class CustomDialogs : DialogFragment() {
    companion object{
        fun showDialogWithText(context: Context, title: String, message: String){
            val builder = AlertDialog.Builder(context)
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.text_dialog, null)
            view.findViewById<TextView>(R.id.dialog_title).text = title
            view.findViewById<TextView>(R.id.dialog_message).text = message
            view.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_warning)

            builder.setView(view)
                .setPositiveButton("Ok"){ dialog, _ ->
                    dialog.dismiss()
                }
            .show()
        }
    }
}