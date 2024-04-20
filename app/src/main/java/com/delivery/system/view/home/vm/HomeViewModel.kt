package com.delivery.system.view.home.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.delivery.system.core.vm.BaseViewModel
import com.delivery.system.model.Order
import com.delivery.system.model.TestData
import com.delivery.system.model.repositories.OrderRepository
import com.delivery.system.model.repositories.OrderRepositoryImpl

class HomeViewModel : BaseViewModel() {
    private val repository: OrderRepository = OrderRepositoryImpl()

    private val _assignedOrder = MutableLiveData<Order>()
    val assignedOrder : LiveData<Order> = _assignedOrder

    private val _openOrders = MutableLiveData<List<Order>>()
    val openOrders : LiveData<List<Order>> = _openOrders

    fun getOpenOrders(){
        launchIO {
            val openOrders = repository.getOpenOrders()
            _openOrders.postValue(openOrders)

            //get driver id from the shared preference
            val assignedOrder = repository.getAssignedOrder(TestData.DRIVER_ID)
            _assignedOrder.postValue(assignedOrder)
        }
    }


}