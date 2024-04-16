package com.delivery.system.model.repositories

interface AppSettingsRepository {
    fun getToken(): String
    fun addToken(token: String)
}