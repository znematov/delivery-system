package com.delivery.system.view.home.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.delivery.system.core.vm.BaseViewModel
import com.delivery.system.model.Order
import com.delivery.system.model.repositories.OrderRepository
import com.delivery.system.model.repositories.OrderRepositoryImpl

class HomeViewModel : BaseViewModel() {
    private val repository: OrderRepository = OrderRepositoryImpl()

    private val _orders = MutableLiveData<List<Order>>()
    val orders : LiveData<List<Order>> = _orders

    fun getOpenOrders(){
        launchIO {
            val openOrders = repository.getOpenOrders()
            _orders.postValue(openOrders)
        }
    }

    fun completeOrder(orderId : String){
        launchIO {
            repository.completeOrder(orderId)
            getOpenOrders()
        }
    }

    fun deliverOrder(orderId: String){
        launchIO {
            repository.deliverOrder(orderId)
            getOpenOrders()
        }
    }
}