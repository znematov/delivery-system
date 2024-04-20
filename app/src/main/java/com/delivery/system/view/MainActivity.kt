package com.delivery.system.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.delivery.system.R
import com.delivery.system.model.repositories.AppSettingsRepository
import com.delivery.system.model.repositories.AppSettingsRepositoryImpl
import com.delivery.system.view.home.view.HomeFragment
import com.delivery.system.view.login.view.LoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var appSettingsRepository: AppSettingsRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appSettingsRepository = AppSettingsRepositoryImpl()

        if (savedInstanceState == null) {
            val token = appSettingsRepository.getToken()
            if (token.isEmpty()) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment())
                    .commitNow()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, HomeFragment())
                    .commitNow()
            }
        }
    }
}