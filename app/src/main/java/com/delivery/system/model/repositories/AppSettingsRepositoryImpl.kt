package com.delivery.system.model.repositories

import android.content.Context
import com.delivery.system.model.db.SharedPreferences

class AppSettingsRepositoryImpl(context: Context) : AppSettingsRepository {
    private val db = SharedPreferences(context)
    override fun getToken(): String {
        return db.get(TOKEN)
    }

    override fun addToken(token: String) {
        db.save(TOKEN, token)
    }

    companion object{
        const val TOKEN="TOKEN"
    }
}