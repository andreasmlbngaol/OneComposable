package com.mightysana.onecomposable.viewmodel

import android.content.Context
import com.mightysana.onecomposable.R
import com.mightysana.onecomposable.composable.auth.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    accountService: AccountService,
    @ApplicationContext private val context: Context
): AuthViewModel(accountService, context) {
    fun validateSignInForm(
        onSuccess: () -> Unit,
    ) {
        resetErrors()
        val validationState = when {
            isEmailBlank()-> FormValidationResult.SignInResult.EmailError(context.getString(R.string.email_blank))
            !isEmailValid() -> FormValidationResult.SignInResult.EmailError(context.getString(R.string.email_invalid))
            isPasswordBlank() -> FormValidationResult.SignInResult.PasswordError(context.getString(R.string.password_blank))
            !isPasswordLengthValid() -> FormValidationResult.SignInResult.PasswordError(context.getString(R.string.password_length_invalid))
            !isPasswordHasNumber() -> FormValidationResult.SignInResult.PasswordError(context.getString(R.string.password_number_invalid))
            !isPasswordHasUpperCase() -> FormValidationResult.SignInResult.PasswordError(context.getString(R.string.password_uppercase_invalid))
            !isPasswordHasLowerCase() -> FormValidationResult.SignInResult.PasswordError(context.getString(R.string.password_lowercase_invalid))
            else -> FormValidationResult.Valid
        }

        when(validationState) {
            is FormValidationResult.SignInResult.EmailError -> setEmailErrorMessage(validationState.message)
            is FormValidationResult.SignInResult.PasswordError -> setPasswordErrorMessage(validationState.message)
            else -> onSuccess()
        }
    }
}

