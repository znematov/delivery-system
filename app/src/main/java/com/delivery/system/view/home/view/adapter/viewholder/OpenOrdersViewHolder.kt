package com.delivery.system.view.home.view.adapter.viewholder

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.delivery.system.R
import com.delivery.system.model.Order
import com.delivery.system.view.home.view.OrderListeners
import com.google.android.material.button.MaterialButton


class OpenOrdersViewHolder(itemView: View, private val orderListeners: OrderListeners) :
    BaseOrdersViewHolder<Order>(itemView) {
    override fun bind(item: Order, hasAssignedOrder: Boolean) {
        itemView.findViewById<TextView>(R.id.tvName).text = item.clientName
        itemView.findViewById<TextView>(R.id.tvAddress).text = item.destinationAddress
        itemView.findViewById<TextView>(R.id.tvID).text = item.id
        itemView.findViewById<TextView>(R.id.tvDate).text = item.registeredDate
        itemView.findViewById<TextView>(R.id.client_phone_number).text = item.clientPhone
        itemView.findViewById<TextView>(R.id.costTextView).text = item.cost.toString() + "c"

        val orderTextView = itemView.findViewById<TextView>(R.id.tvOrder)
        val text = "Order status: " + item.orderStatus.name
        orderTextView.text = text
        when (item.orderStatus.name) {
            "DONE" -> orderTextView.setTextColor(Color.GREEN)
            "GOING" -> orderTextView.setTextColor(Color.RED)
            "READY" -> orderTextView.setTextColor(Color.BLUE)
        }

        itemView.findViewById<MaterialButton>(R.id.DetailsButton).setOnClickListener {
            orderListeners.showDetails(item.destinationAddress)
        }

        val deliverButton = itemView.findViewById<MaterialButton>(R.id.DeliverButton)

        if (hasAssignedOrder) {
            deliverButton.isEnabled = false
            deliverButton.setBackgroundColor(Color.GRAY)
        } else {
            deliverButton.isEnabled = true
            deliverButton.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.button_login_color
                )
            )
            deliverButton.setOnClickListener {
                orderListeners.deliverOrder(item.id)
            }
        }
    }

    override fun bind(item: Order) {
        TODO("Not yet implemented")
    }
}
