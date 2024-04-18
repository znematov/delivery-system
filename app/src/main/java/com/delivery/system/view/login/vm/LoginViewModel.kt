package com.delivery.system.view.login.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.delivery.system.core.vm.BaseViewModel
import com.delivery.system.model.repositories.AuthenticationRepositoryImpl
import com.delivery.system.model.LoginDto
import com.delivery.system.model.repositories.AppSettingsRepository

class LoginViewModel : BaseViewModel()
{
    private var appSettingsRepository : AppSettingsRepository? = null

    private val resultData = MutableLiveData<Boolean>()
    val loginResult : LiveData<Boolean> = resultData

    private val _loading:MutableLiveData<Boolean> = MutableLiveData()
    val loading:LiveData<Boolean> = _loading

    private val authRepository = AuthenticationRepositoryImpl()
    fun login(login: String, password: String) {

        val loginDto = LoginDto(login, password)
        launchIO {
            _loading.postValue(true)
            val result = authRepository.login(loginDto)
            if (result.isLoginValid)
                appSettingsRepository!!.addToken(result.token)
            resultData.postValue(result.isLoginValid)
            _loading.postValue(false)
        }
    }

    fun setRepository(repository: AppSettingsRepository){
        appSettingsRepository = repository
    }
}