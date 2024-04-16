package com.delivery.system.view.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delivery.system.R
import com.delivery.system.core.view.BaseAdapter
import com.delivery.system.view.home.view.adapter.viewholder.HomeViewHolder

data class User(
    val name: String,
    val address: String,
    val id: String,
    val image: Int
)

class HomeAdapter(private val item: List<User>, private val onUserClicked: () -> Unit)
    : BaseAdapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return HomeViewHolder(view, onUserClicked)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }
}