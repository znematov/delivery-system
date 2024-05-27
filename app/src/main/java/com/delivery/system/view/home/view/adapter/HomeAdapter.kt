package com.delivery.system.view.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.delivery.system.R
import com.delivery.system.core.view.BaseAdapter
import com.delivery.system.core.view.BaseViewHolder
import com.delivery.system.model.Order
import com.delivery.system.model.OrderStatus
import com.delivery.system.view.home.view.OrderListeners
import com.delivery.system.view.home.view.adapter.viewholder.AssignedOrderViewHolder
import com.delivery.system.view.home.view.adapter.viewholder.BaseOrdersViewHolder
import com.delivery.system.view.home.view.adapter.viewholder.OpenOrdersViewHolder

class HomeAdapter(
    private val items: MutableList<Order> = mutableListOf(),
    private val orderListeners: OrderListeners
) : BaseAdapter<BaseOrdersViewHolder<Order>>() {

    private val hasAssignedOrder: Boolean
        get() {
            return items.any {
                it.orderStatus.name == "GOING"
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseOrdersViewHolder<Order> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewHolder = when (viewType) {
            OPEN_ORDER -> OpenOrdersViewHolder(
                layoutInflater.inflate(
                    R.layout.open_order_item,
                    parent,
                    false
                ),
                orderListeners
            )

            else -> AssignedOrderViewHolder(
                layoutInflater.inflate(
                    R.layout.assigned_order_item,
                    parent,
                    false
                ),
                orderListeners
            )
        }
        return viewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].orderStatus.name == "GOING")
            ASSIGNED_ORDER
        else {
            OPEN_ORDER
        }
    }

    companion object {
        const val ASSIGNED_ORDER = 1
        const val OPEN_ORDER = 2
    }

    override fun onBindViewHolder(holder: BaseOrdersViewHolder<Order>, position: Int) {
        holder.bind(items[position], hasAssignedOrder)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newItems: List<Order>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}