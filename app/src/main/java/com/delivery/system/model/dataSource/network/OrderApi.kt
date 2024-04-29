package com.delivery.system.model.dataSource.network

import com.delivery.system.model.Order
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface OrderApi {
    @GET("order/assigned/{driverId}")
    suspend fun getAssignedOrder(@Path("driverId") driverId: String): Order

    @GET("orders/open")
    suspend fun getOpenOrders(): List<Order>

    @GET("orders/completed/{driverId}")
    suspend fun getCompletedOrders(@Path("driverId") driverId: String): List<Order>

    @POST("order/deliver/{orderId}")
    suspend fun deliverOrder(@Path("orderId") orderId: String)

    @PUT("order/complete/{orderId}")
    suspend fun completeOrder(@Path("orderId") orderId: String)
}