package com.delivery.system.model.repositories

import com.delivery.system.model.Order
import com.delivery.system.model.dataSource.network.NetworkClient
import com.delivery.system.model.dataSource.OrderApi

class OrderRepositoryImpl : OrderRepository {
    private val dataSource = NetworkClient.retrofit.create(OrderApi::class.java)
    override suspend fun getAssignedOrder(driverId: String): Order {
        return dataSource.getAssignedOrder(driverId)
    }

    override suspend fun getOpenOrders(): List<Order> {
        return dataSource.getOpenOrders()
    }

    override suspend fun getCompletedOrders(driverId: String): List<Order> {
        return dataSource.getCompletedOrders(driverId)
    }

    override suspend fun deliverOrder(orderId: String) {
        return dataSource.deliverOrder(orderId)
    }

    override suspend fun completeOrder(orderId: String) {
        return dataSource.completeOrder(orderId)
    }
}