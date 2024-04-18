package com.delivery.system.model.repositories

import android.content.Context
import com.delivery.system.model.db.LocalStorage

class AppSettingsRepositoryImpl : AppSettingsRepository {
    override fun getToken(): String {
        return LocalStorage.get(TOKEN)
    }

    override fun setToken(token: String) {
        LocalStorage.save(TOKEN, token)
    }

    companion object{
        const val TOKEN="TOKEN"
    }
}