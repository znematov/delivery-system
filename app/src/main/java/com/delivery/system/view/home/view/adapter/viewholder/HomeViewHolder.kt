package com.delivery.system.view.home.view.adapter.viewholder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.delivery.system.R
import com.delivery.system.core.view.BaseViewHolder
import com.delivery.system.view.home.view.adapter.User


class HomeViewHolder(itemView: View, private val onUserClicked: () -> Unit) : BaseViewHolder<User>(itemView) {
    override fun bind(item: User) {
        itemView.findViewById<TextView>(R.id.tvName).text = item.name
        itemView.findViewById<TextView>(R.id.tvAddress).text = item.address
        itemView.findViewById<TextView>(R.id.tvID).text = item.id
        itemView.findViewById<ImageView>(R.id.imageView).setImageResource(item.image)
        itemView.findViewById<Button>(R.id.DetailsButton).setOnClickListener {
             onUserClicked.invoke()
        }
    }
}
