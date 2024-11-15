package com.mightysana.onecomposable.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mightysana.onecomposable.composable.auth.AccountService
import com.mightysana.onecomposable.model.NetworkStatusTracker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class OneViewModel(
    protected val accountService: AccountService,
    context: Context
): ViewModel() {
    private val networkStatusTracker: NetworkStatusTracker = NetworkStatusTracker(context)
    private val _isNetworkAvailable = MutableStateFlow(true)
    val isNetworkAvailable: StateFlow<Boolean> = _isNetworkAvailable

    fun signOut() {
        viewModelScope.launch {
            accountService.signOut()
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

}