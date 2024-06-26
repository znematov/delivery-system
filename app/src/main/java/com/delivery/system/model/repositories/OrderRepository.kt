package com.delivery.system.model.repositories

import com.delivery.system.model.Order

interface OrderRepository {
    suspend fun getAssignedOrder(driverId: String): Order
    suspend fun getOpenOrders() : List<Order>
    suspend fun getCompletedOrders(driverId: String): List<Order>
    suspend fun deliverOrder(orderId: String)
    suspend fun completeOrder(orderId: String)
}