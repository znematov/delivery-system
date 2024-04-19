package com.delivery.system.view.home.view


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delivery.system.R
import com.delivery.system.view.details.view.DeliveryDetailFragment
import com.delivery.system.view.home.view.adapter.User
import com.delivery.system.view.home.view.adapter.HomeAdapter
import com.google.android.material.navigation.NavigationView

class HomeFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeAdapter
    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        recyclerView = view.findViewById(R.id.RView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = HomeAdapter(users()){
            DeliveryDetailFragment().show(childFragmentManager,null)
        }
        recyclerView.adapter = adapter

        drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)

        val burger = view.findViewById<ImageView>(R.id.imBurger)

        burger.setOnClickListener {
            drawerLayout.open()
        }


        val navigationView = view.findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)


        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}
