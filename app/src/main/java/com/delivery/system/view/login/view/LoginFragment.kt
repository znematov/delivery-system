package com.delivery.system.view.login.view

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.delivery.system.R
import com.delivery.system.core.view.BaseFragment
import com.delivery.system.core.view.CustomDialogs
import com.delivery.system.model.repositories.AppSettingsRepositoryImpl
import com.delivery.system.view.home.view.HomeFragment
import com.delivery.system.view.login.vm.LoginViewModel

class LoginFragment : BaseFragment(R.layout.login_fragment) {

    private lateinit var viewModel: LoginViewModel
    private lateinit var loginButton : Button

    override fun onInitListeners() {
        super.onInitListeners()
        loginButton.setOnClickListener {
            val login = findViewById<TextView>(R.id.login).text.toString()
            val password = findViewById<TextView>(R.id.password).text.toString()
            viewModel.login(login,password)
        }
    }

    override fun onInitObservers() {
        super.onInitObservers()
        viewModel.loading.observe(viewLifecycleOwner){
            if (it){
                findViewById<LinearLayout>(R.id.login_content).visibility = View.INVISIBLE
                findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
            }
            else{
                findViewById<ProgressBar>(R.id.progressBar).visibility = View.INVISIBLE
                findViewById<LinearLayout>(R.id.login_content).visibility = View.VISIBLE
            }
        }

        viewModel.loginResult.observe(viewLifecycleOwner){
            if (it){
                transaction(R.id.container,HomeFragment(),false)
            }
            else{
                CustomDialogs.showDialogWithText(requireContext(),"Could not login",
                    "Please check your login or password")
            }
        }
    }

    override fun onInitView() {
        super.onInitView()
        loginButton = findViewById(R.id.loginButton)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        viewModel.setRepository(AppSettingsRepositoryImpl(requireContext()))
    }
}