package com.mightysana.onecomposable.viewmodel

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mightysana.onecomposable.model.services.AccountService
import com.mightysana.onecomposable.model.NetworkStatusTracker
import com.mightysana.onecomposable.model.OneRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class OneViewModel(
    protected val accountService: AccountService,
    protected val oneRepository: OneRepository,
    protected val application: Application
): ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun appLoading() {
        _isLoading.value = true
    }

    fun appLoaded() {
        _isLoading.value = false
    }

    private val networkStatusTracker: NetworkStatusTracker = NetworkStatusTracker(application)
    private val _isNetworkAvailable = MutableStateFlow(true)
    val isNetworkAvailable: StateFlow<Boolean> = _isNetworkAvailable

    protected fun launchCatching(
        exception: (Throwable) -> Unit = {},
        block: suspend CoroutineScope.() -> Unit
    ) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Exception) {
                Log.e("OneViewModel", e.message.toString())
                exception(e)
            }
        }
    }

    fun onSignOut(onSuccess: () -> Unit) {
        viewModelScope.launch {
            accountService.signOut()
            onSuccess()
        }
    }

    private fun observeNetworkStatus() {
        viewModelScope.launch {
            networkStatusTracker.isNetworkAvailable.collectLatest { isConnected ->
                _isNetworkAvailable.value = isConnected
            }
        }
    }

    init {
        observeNetworkStatus()
    }

    protected fun openOtherApp(
        category: String,
        packageName: String,
        flags: Int = Intent.FLAG_ACTIVITY_NEW_TASK
    ) {
        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(category)
            setPackage(packageName)
            addFlags(flags)
        }
        try {
            application.startActivity(intent)
        } catch (e: Exception) {
            Log.e("OneViewModel", e.toString())
            e.printStackTrace()
        }
    }

    fun toast(message: String) {
        application.toast(message)
    }

    fun toast(@StringRes messageStringRes: Int) {
        application.toast(messageStringRes)
    }

    fun comingSoon() {
        toast("Coming Soon 😊")
    }
}

fun Application.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Application.toast(@StringRes messageStringRes: Int) {
    Toast.makeText(this, this.getString(messageStringRes), Toast.LENGTH_SHORT).show()
}
