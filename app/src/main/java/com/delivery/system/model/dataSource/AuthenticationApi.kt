package com.delivery.system.model.dataSource

import com.delivery.system.model.LoginDto
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthenticationApi {
    @POST("login")
    suspend fun login(@Body loginData : LoginDto) : TokenDto
}