package com.delivery.system.main.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.delivery.system.R
import com.delivery.system.core.ui.BaseFragment
import com.delivery.system.main.vm.LoginViewModel

class LoginFragment : BaseFragment(R.layout.login_fragment) {

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginTextView = findViewById<TextView>(R.id.login)
        val passwordTextView = findViewById<TextView>(R.id.password)
        val serverAddressTextView = findViewById<TextView>(R.id.serverAddress)

        findViewById<Button>(R.id.loginButton).setOnClickListener {
            val loginResult = viewModel.login(
                loginTextView.text.toString(),
                passwordTextView.text.toString(),
                serverAddressTextView.text.toString()
            )

            if (loginResult){
                transaction(R.id.container, MainFragment(), true)
            }
        }
    }
}