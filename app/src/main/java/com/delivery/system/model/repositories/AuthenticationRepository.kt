package com.delivery.system.model.repositories

import com.delivery.system.model.LoginDto
import com.delivery.system.model.dataSource.TokenDto

interface AuthenticationRepository {
    suspend fun login(loginDto: LoginDto) : TokenDto
}