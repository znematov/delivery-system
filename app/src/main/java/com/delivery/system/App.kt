package com.delivery.system

import android.app.Application
import com.delivery.system.model.db.LocalStorage

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LocalStorage.init(this)
    }
}