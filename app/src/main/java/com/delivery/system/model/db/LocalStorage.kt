package com.delivery.system.model.db

import android.content.Context
import android.content.SharedPreferences

object LocalStorage {
    private var sharedPreferences : SharedPreferences? = null

    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences("SharedPreferences",
            Context.MODE_PRIVATE)
    }

    fun save(key:String, value:String){
        val editor = sharedPreferences!!.edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun get(key: String): String {
        return sharedPreferences!!.getString(key, "") ?: ""
    }
}