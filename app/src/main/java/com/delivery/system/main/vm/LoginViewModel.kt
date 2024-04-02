package com.delivery.system.main.vm

import com.delivery.system.main.repository.AuthRepository
import com.delivery.system.main.repository.AuthRepositoryImpl
import com.delivery.system.core.ui.BaseViewModel
import com.delivery.system.main.model.UserData

class LoginViewModel : BaseViewModel() {

    private val authRepository: AuthRepository = AuthRepositoryImpl()

    fun login(login: String, password: String, serverAddress: String) : Boolean {
        val userData = UserData(login, password)
        val authenticateResult = authRepository.login(userData)
        // save to shared preference
        return authenticateResult.isLoginValid
    }

}