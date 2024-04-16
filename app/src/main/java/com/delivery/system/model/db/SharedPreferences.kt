package com.delivery.system.model.db

import android.content.Context

class SharedPreferences(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("SharedPreferences",
        Context.MODE_PRIVATE)

    fun save(key:String, value:String){
        val editor = sharedPreferences.edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun get(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }
}