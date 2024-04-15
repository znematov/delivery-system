package com.delivery.system.main.ui.fragment
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.delivery.system.R

data class User(
    val name:String,
    val address: String,
    val id: String,
    val image: Int
)

class UserAdapter(private val item: List<User>,private val onUserClicked: () -> Unit) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun onBind(user: User, onUserClicked : () -> Unit){

            itemView.findViewById<TextView>(R.id.tvName).text = user.name
            itemView.findViewById<TextView>(R.id.tvAddress).text = user.address
            itemView.findViewById<TextView>(R.id.tvID).text = user.id
            itemView.findViewById<ImageView>(R.id.imageView).setImageResource(user.image)
            itemView.findViewById<Button>(R.id.DetailsButton).setOnClickListener{
                onUserClicked.invoke()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(item[position],onUserClicked)
    }

    override fun getItemCount(): Int {
        return item.size
    }





}