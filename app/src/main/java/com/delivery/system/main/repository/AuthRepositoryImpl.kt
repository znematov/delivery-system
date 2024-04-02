package com.delivery.system.main.repository

import com.delivery.system.main.model.TokenDto
import com.delivery.system.main.model.UserData

class AuthRepositoryImpl : AuthRepository {

    override fun login(userData: UserData) : TokenDto {
        //connect to the server and login
        return TokenDto("jwt", true, "bob")
    }

}