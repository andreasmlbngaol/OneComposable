package com.mightysana.onecomposable.composable.auth

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.mightysana.onecomposable.model.AUTH_GRAPH
import com.mightysana.onecomposable.model.EMAIL_VERIFICATION
import com.mightysana.onecomposable.model.SIGN_IN

@Composable
fun AuthCheck(
    mainRoute: String,
    accountService: AccountService,
    onAuthenticationResult: (String, String) -> Unit
) {
    LaunchedEffect(Unit) {
        try {
            accountService.reloadUser()
            Log.d("AuthCheck", "User logged in: ${accountService.currentUser}")
            // userLoggedIn
            if (accountService.currentUser == null) {
                onAuthenticationResult(AUTH_GRAPH, SIGN_IN)
            } else if (!accountService.isEmailVerified()) {
                onAuthenticationResult(AUTH_GRAPH, EMAIL_VERIFICATION)
            } else {
                onAuthenticationResult(mainRoute, SIGN_IN)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}