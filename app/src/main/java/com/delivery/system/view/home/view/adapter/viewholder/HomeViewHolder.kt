package com.delivery.system.view.home.view.adapter.viewholder

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.delivery.system.R
import com.delivery.system.core.view.BaseViewHolder
import com.delivery.system.model.Order


class HomeViewHolder(itemView: View, private val onUserClicked: () -> Unit) : BaseViewHolder<Order>(itemView) {
    override fun bind(item: Order) {
        itemView.findViewById<TextView>(R.id.tvName).text = item.clientName
        itemView.findViewById<TextView>(R.id.tvAddress).text = item.destinationAddress
        itemView.findViewById<TextView>(R.id.tvID).text = item.id
        itemView.findViewById<TextView>(R.id.tvDate).text = item.registeredDate
        itemView.findViewById<TextView>(R.id.costTextView).text = item.cost.toString() + "c"

        val orderTextView = itemView.findViewById<TextView>(R.id.tvOrder)
        val text = "Order status: " + item.orderStatus.name
        orderTextView.text = text
        when (item.orderStatus.name){
            "DONE" -> orderTextView.setTextColor(Color.GREEN)
            "GOING" -> orderTextView.setTextColor(Color.RED)
            "READY" -> orderTextView.setTextColor(Color.BLUE)
        }

        itemView.findViewById<Button>(R.id.DetailsButton).setOnClickListener {
             onUserClicked.invoke()
        }
    }
}
