package com.mightysana.onecomposable.viewmodel

import android.content.Context
import android.util.Log
import androidx.credentials.Credential
import androidx.credentials.CustomCredential
import androidx.lifecycle.viewModelScope
import com.mightysana.onecomposable.composable.auth.AccountService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL

abstract class AuthViewModel(
    accountService: AccountService,
    @ApplicationContext context: Context,
): OneViewModel(accountService, context) {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    fun updateEmail(email: String) {
        _email.value = email.lowercase().replace(" ", "")
    }

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun updatePassword(password: String) {
        _password.value = password.replace(" ", "")
    }

    private val _visible = MutableStateFlow(false)
    val visible = _visible.asStateFlow()

    fun togglePasswordVisibility() {
        _visible.value = !_visible.value
    }

    private val _isEmailError = MutableStateFlow(false)
    val isEmailError = _isEmailError.asStateFlow()

    private fun setEmailError(error: Boolean) {
        _isEmailError.value = error
    }

    private val _isPasswordError = MutableStateFlow(false)
    val isPasswordError = _isPasswordError.asStateFlow()

    private fun setPasswordError(error: Boolean) {
        _isPasswordError.value = error
    }

    private val _emailErrorMessage = MutableStateFlow<String?>(null)
    val emailErrorMessage = _emailErrorMessage.asStateFlow()

    protected fun setEmailErrorMessage(message: String) {
        _emailErrorMessage.value = message
        if(message.isNotBlank()) setEmailError(true) else setEmailError(false)

    }

    private val _passwordErrorMessage = MutableStateFlow<String?>(null)
    val passwordErrorMessage = _passwordErrorMessage.asStateFlow()

    protected fun setPasswordErrorMessage(message: String) {
        _passwordErrorMessage.value = message
        if(message.isNotBlank()) setPasswordError(true) else setPasswordError(false)
    }

    protected fun isEmailBlank(): Boolean {
        return _email.clip().isBlank()
    }

    protected fun isEmailValid(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(_email.clip()).matches()
    }


    protected fun isPasswordBlank(): Boolean {
        return _password.clip().isBlank()
    }

    protected fun isPasswordLengthValid(): Boolean {
        return _password.clip().length >= 8
    }

    protected fun isPasswordHasNumber(): Boolean {
        return Regex(".*\\d.*").matches(_password.clip())
    }

    protected fun isPasswordHasUpperCase(): Boolean {
        return Regex(".*[A-Z].*").matches(_password.clip())
    }

    protected fun isPasswordHasLowerCase(): Boolean {
        return Regex(".*[a-z].*").matches(_password.clip())
    }

    // Reset Values
    private fun resetEmailError() {
        _isEmailError.value = false
        _emailErrorMessage.value = null
    }

    private fun resetPasswordError() {
        _isPasswordError.value = false
        _passwordErrorMessage.value = null
    }

    protected open fun resetErrors() {
        resetEmailError()
        resetPasswordError()
    }

    fun onSignInWithGoogle(
        credential: Credential,
        onSuccess: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                    accountService.signInWithGoogle(googleIdTokenCredential.idToken)
                }
                Log.d("AuthViewModel", "Success")
                while (accountService.currentUser == null) {
                    delay(500L)
                }

                onSuccess("Main")

            } catch (e: Exception) {
                Log.e("AuthViewModel", "onSignInWithGoogle: $e")
                e.printStackTrace()
            }
        }
    }

}

sealed class FormValidationResult {
    data object Valid: FormValidationResult()

    sealed class SignInResult: FormValidationResult() {
        data class EmailError(val message: String): SignInResult()
        data class PasswordError(val message: String): SignInResult()
    }

    sealed class SignUpResult: FormValidationResult() {
        data class EmailError(val message: String): SignUpResult()
        data class PasswordError(val message: String): SignUpResult()
        data class ConfirmPasswordError(val message: String): SignUpResult()
    }
}

fun MutableStateFlow<String>.clip(): String {
    return this.value.trim()
}
