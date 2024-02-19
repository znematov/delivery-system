package com.delivery.system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener{
            val toast = Toast(this)
            toast.setText("Logged in")
            toast.show()
        }
    }
}