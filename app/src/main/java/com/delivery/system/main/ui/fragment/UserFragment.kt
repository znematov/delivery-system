package com.delivery.system.main.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delivery.system.R

class UserFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_main, container, false)

        recyclerView = view.findViewById(R.id.RView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = UserAdapter(users())
        recyclerView.adapter = adapter

        return view
    }

    private fun users(): List<User> {
        val item = listOf(
            User(
                name = "Muhammed",
                address = "Khujand, Street 25",
                id = "D346HI98",
                image = R.drawable.avatar
            ),
            User(
                name = "Alisher",
                address = "Khujand, Street 32",
                id = "D367DN89",
                image = R.drawable.avatar2
            ),
            User(
                name = "Aziz",
                address = "Khujand, Street 13",
                id = "D320F4E9",
                image = R.drawable.avatar3
            ),
        )
        return item

    }
}