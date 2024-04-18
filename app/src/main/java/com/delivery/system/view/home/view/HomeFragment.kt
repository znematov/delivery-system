package com.delivery.system.view.home.view


import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delivery.system.R
import com.delivery.system.core.view.BaseFragment
import com.delivery.system.view.details.view.DeliveryDetailFragment
import com.delivery.system.view.home.view.adapter.HomeAdapter
import com.delivery.system.view.home.vm.HomeViewModel

class HomeFragment : BaseFragment(R.layout.main_fragment) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeAdapter
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
    }

    override fun onInitObservers() {
        viewModel.openOrders.observe(viewLifecycleOwner){
            adapter.updateItems(viewModel.openOrders.value!!)
        }
    }

    /*private fun users(): List<User> {
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

    }*/
}
