package com.delivery.system.view.home.view.adapter.viewholder

import android.graphics.Color
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import com.delivery.system.R
import com.delivery.system.model.Order
import com.delivery.system.view.home.view.HomeViewConstants
import com.delivery.system.view.home.view.OrderListeners
import com.google.android.material.button.MaterialButton


class AssignedOrderViewHolder(
    itemView: View,
    private val orderListeners: OrderListeners
) : BaseOrdersViewHolder<Order>(itemView) {

    override fun bind(item: Order, hasAssignedOrder: Boolean) {
        itemView.findViewById<TextView>(R.id.tvName).text = item.clientName
        itemView.findViewById<TextView>(R.id.tvAddress).text = item.destinationAddress
        itemView.findViewById<TextView>(R.id.tvID).text = item.id
        itemView.findViewById<TextView>(R.id.tvDate).text = item.registeredDate
        itemView.findViewById<TextView>(R.id.client_phone_number).text = item.clientPhone
        itemView.findViewById<TextView>(R.id.costTextView).text = item.cost.toString() + "c"

        val orderTextView = itemView.findViewById<TextView>(R.id.tvOrder)
        val text = "Статус заказа: " + item.orderStatus.name
        orderTextView.text = text
        when (item.orderStatus.name) {
            "DONE" -> orderTextView.setTextColor(Color.GREEN)
            "GOING" -> orderTextView.setTextColor(Color.RED)
            "READY" -> orderTextView.setTextColor(Color.BLUE)
        }

        itemView.findViewById<MaterialButton>(R.id.DetailsButton).setOnClickListener {
            orderListeners.showDetails(item.destinationAddress)
        }

        itemView.findViewById<MaterialButton>(R.id.complete_delivery_button).setOnClickListener {
            orderListeners.completeDelivery(item.id)
        }

        itemView.findViewById<MaterialButton>(R.id.show_on_map_button).setOnClickListener {
            orderListeners.showMap(item.destinationAddress)
        }

        val showOnMapButton = itemView.findViewById<MaterialButton>(R.id.show_on_map_button)
        val arrivedButton = itemView.findViewById<MaterialButton>(R.id.arrived_button)
        val callToClientButton = itemView.findViewById<MaterialButton>(R.id.call_client_button)
        val completeButton = itemView.findViewById<MaterialButton>(R.id.complete_delivery_button)
        val timerText = findById<TextView>(R.id.timer_text)
        arrivedButton.setOnClickListener {
            timerText.visibility = View.VISIBLE
            callToClientButton.visibility = View.VISIBLE
            object:CountDownTimer(HomeViewConstants.ARRIVED_TIMER,1000){
                override fun onTick(millisUntilFinished: Long) {
                    val minutes = (millisUntilFinished / 1000) / 60
                    val seconds = (millisUntilFinished / 1000) % 60
                    timerText.text = "$minutes:$seconds"
                }

                override fun onFinish() {
                    completeButton.visibility = View.VISIBLE
                    timerText.visibility = View.INVISIBLE
                    callToClientButton.visibility = View.INVISIBLE
                }

            }.start()
            arrivedButton.visibility = View.INVISIBLE
            showOnMapButton.visibility = View.INVISIBLE
        }
        callToClientButton.setOnClickListener {
            orderListeners.openDialer(item.clientPhone)
        }
    }

    override fun bind(item: Order) {
        TODO("Not yet implemented")
    }

}