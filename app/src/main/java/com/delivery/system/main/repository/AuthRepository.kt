package com.delivery.system.main.repository

import com.delivery.system.main.model.TokenDto
import com.delivery.system.main.model.UserData

interface AuthRepository {
    fun login(userData: UserData) : TokenDto
}