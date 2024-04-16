package com.delivery.system.core.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    private val context = SupervisorJob() + Dispatchers.Main

    protected val viewModelScope = CoroutineScope(context)

    protected fun launchUI(block: suspend () -> Unit): Job {
        return viewModelScope.launch(Dispatchers.Main) {
            block()
        }
    }

    protected fun launchIO(block: suspend () -> Unit): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            block()
        }
    }

    protected fun launchDefault(block: suspend () -> Unit): Job {
        return viewModelScope.launch(Dispatchers.Default) {
            block()
        }
    }
}