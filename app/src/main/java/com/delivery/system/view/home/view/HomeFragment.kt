package com.delivery.system.view.home.view


import android.content.Intent
import android.net.Uri
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.delivery.system.R
import com.delivery.system.core.view.BaseFragment
import com.delivery.system.model.repositories.AppSettingsRepository
import com.delivery.system.model.repositories.AppSettingsRepositoryImpl
import com.delivery.system.view.details.view.DeliveryDetailFragment
import com.delivery.system.view.home.view.adapter.HomeAdapter
import com.delivery.system.view.home.vm.HomeViewModel
import com.delivery.system.view.login.view.LoginFragment
import com.delivery.system.view.signature.view.SignatureDialogFragment
import com.google.android.material.navigation.NavigationView

class HomeFragment : BaseFragment(R.layout.main_fragment),
    NavigationView.OnNavigationItemSelectedListener, OrderListeners {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeAdapter
    private lateinit var viewModel: HomeViewModel
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var appSettingsRepository: AppSettingsRepository
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onInitView() {
        super.onInitView()
        drawerLayout = findViewById(R.id.drawer_layout)
        toolbar = findViewById(R.id.toolbar)
        initToolBarAndDrawer()
        appSettingsRepository = AppSettingsRepositoryImpl()
        swipeRefresh = findViewById(R.id.swipe_refresh)
        swipeRefresh.isRefreshing = false
        recyclerView = findViewById(R.id.RView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = HomeAdapter(orderListeners = this)
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getOpenOrders()
    }

    override fun onResume() {
        println()
        super.onResume()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
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
        viewModel.orders.observe(viewLifecycleOwner) {
            adapter.updateItems(viewModel.orders.value!!)
        }
    }

    override fun onInitListeners() {
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = false
            viewModel.getOpenOrders()
        }
    }

    override fun showMap(address: String) {
        val map = "geo:0,0?q=$address"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(map))
        startActivity(intent)
    }

    override fun showDetails(address: String) {
        DeliveryDetailFragment(address).show(childFragmentManager, null)
    }

    override fun completeDelivery(orderId: String) {
        SignatureDialogFragment(orderId).show(childFragmentManager, null)
    }

    override fun deliverOrder(orderId: String) {
        viewModel.deliverOrder(orderId)
    }

    override fun openDialer(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }
}

interface OrderListeners {
    fun showMap(address: String)
    fun showDetails(address: String)
    fun completeDelivery(orderId: String)
    fun deliverOrder(orderId: String)
    fun openDialer(phoneNumber: String)
}
