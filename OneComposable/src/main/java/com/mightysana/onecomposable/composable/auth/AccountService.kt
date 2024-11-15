package com.mightysana.onecomposable.composable.auth

import com.google.firebase.auth.FirebaseUser

interface AccountService {
    val currentUser: FirebaseUser?
    suspend fun reloadUser()
    suspend fun isEmailVerified(): Boolean
    suspend fun signInWithGoogle(idToken: String)
    suspend fun signInWithEmailAndPassword(email: String, password: String)
    suspend fun signOut()
}