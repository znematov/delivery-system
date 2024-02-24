package com.delivery.system

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val login = intent.getStringExtra("Login")
        findViewById<TextView>(R.id.textLogin).text = login
    }
}