package com.delivery.system.view.home.view


import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delivery.system.R
import com.delivery.system.core.view.BaseFragment
import com.delivery.system.model.repositories.AppSettingsRepository
import com.delivery.system.model.repositories.AppSettingsRepositoryImpl
import com.delivery.system.view.details.view.DeliveryDetailFragment
import com.delivery.system.view.home.view.adapter.HomeAdapter
import com.delivery.system.view.home.vm.HomeViewModel
import com.delivery.system.view.login.view.LoginFragment
import com.google.android.material.navigation.NavigationView

class HomeFragment : BaseFragment(R.layout.main_fragment) , NavigationView.OnNavigationItemSelectedListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeAdapter
    private lateinit var viewModel: HomeViewModel
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var appSettingsRepository: AppSettingsRepository

    override fun onInitView() {
        super.onInitView()
        drawerLayout = findViewById(R.id.drawer_layout)
        toolbar = findViewById(R.id.toolbar)
        initToolBarAndDrawer()
        appSettingsRepository = AppSettingsRepositoryImpl()
        recyclerView = findViewById(R.id.RView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = HomeAdapter{
            DeliveryDetailFragment(it).show(childFragmentManager,null)
        }
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getOpenOrders()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> {
                appSettingsRepository.setToken("")
                transaction(R.id.container, LoginFragment())
            }
        }
        return true
    }

    private fun initToolBarAndDrawer() {
        val appCompatActivity = requireActivity() as AppCompatActivity
        appCompatActivity.setSupportActionBar(toolbar)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            requireActivity(),
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setCheckedItem(R.id.home)
    }

    override fun onInitObservers() {
        viewModel.openOrders.observe(viewLifecycleOwner){
            adapter.updateItems(viewModel.openOrders.value!!)
        }
    }
}
