package com.delivery.system.model.repositories

import com.delivery.system.model.LoginDto
import com.delivery.system.model.dataSource.AuthenticationApi
import com.delivery.system.model.dataSource.TokenDto
import com.delivery.system.model.dataSource.network.NetworkClient

class AuthenticationRepository {
    private val dataSource = NetworkClient.retrofit.create(AuthenticationApi::class.java)

    suspend fun login(loginDto: LoginDto) : TokenDto{
        return dataSource.login(loginDto)
    }
}