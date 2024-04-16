package com.delivery.system.view.login.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.delivery.system.R
import com.delivery.system.core.view.BaseFragment
import com.delivery.system.view.home.view.HomeFragment

class LoginFragment : BaseFragment(R.layout.login_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findViewById<Button>(R.id.loginButton).setOnClickListener {
            transaction(R.id.container,HomeFragment(), true)
        }
    }
}