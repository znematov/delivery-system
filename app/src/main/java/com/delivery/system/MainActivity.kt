package com.delivery.system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.delivery.system.main.ui.fragment.LoginFragment
import com.delivery.system.main.ui.fragment.UserFragment

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