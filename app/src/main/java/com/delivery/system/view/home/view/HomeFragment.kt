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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delivery.system.R
import com.delivery.system.core.view.BaseFragment
import com.delivery.system.view.details.view.DeliveryDetailFragment
import com.delivery.system.view.home.view.adapter.HomeAdapter
import com.delivery.system.view.home.vm.HomeViewModel
import com.google.android.material.navigation.NavigationView

class HomeFragment : BaseFragment(R.layout.main_fragment) , NavigationView.OnNavigationItemSelectedListener{

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeAdapter
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModel: HomeViewModel

    override fun onInitView() {
        super.onInitView()
        recyclerView = findViewById(R.id.RView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = HomeAdapter{
            DeliveryDetailFragment().show(childFragmentManager,null)
        }
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getOpenOrders()

        drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)

        val burger = view.findViewById<ImageView>(R.id.imBurger)

        burger.setOnClickListener {
            drawerLayout.open()
        }

        val navigationView = view.findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onInitObservers() {
        viewModel.openOrders.observe(viewLifecycleOwner){
            adapter.updateItems(viewModel.openOrders.value!!)
        }
    }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}
