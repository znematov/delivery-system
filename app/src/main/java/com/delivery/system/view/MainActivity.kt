package com.delivery.system.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.delivery.system.R
import com.delivery.system.view.login.view.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commitNow()
        }
    }
}