package com.delivery.system.view.home.view.adapter.viewholder

import android.view.View
import com.delivery.system.core.view.BaseViewHolder

abstract class BaseOrdersViewHolder<T>(itemView: View) : BaseViewHolder<T>(itemView) {
    abstract fun bind(item: T, hasAssignedOrder:Boolean = false)
}