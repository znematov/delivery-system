package com.delivery.system.model

data class Order(
    val orderDriver: String?,
    val cost: Double,
    val orderStatus: OrderStatus,
    val destinationAddress: String,
    val registeredDate: String,
    val completedDate: String?
)