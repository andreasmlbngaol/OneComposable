package com.mightysana.onecomposable.model

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mightysana.onecomposable.composable.OneTextButton
import com.mightysana.onecomposable.composable.auth.sign_in.SignInScreen

fun NavGraphBuilder.authGraph(
    navController: NavHostController,
    mainRoute: String,
    defaultWebClientId: String,
    startDestination: String = SIGN_IN
) {
    navigation(
        route = AUTH_GRAPH,
        startDestination = startDestination
    ) {
        composable(SIGN_IN) {
            SignInScreen(
                navController = navController,
                mainRoute = mainRoute,
                defaultWebClientId = defaultWebClientId
            )
        }
        composable(SIGN_UP) {
            OneTextButton(
                {
                    navController.navigateAndPopUp(SIGN_IN, SIGN_UP)
                },
                modifier = Modifier.padding(top = 50.dp)
            ) {
                Text("Go to Sign In")
            }
        }
        composable(EMAIL_VERIFICATION) {
            OneTextButton(
                {
                    navController.navigateAndPopUp(SIGN_IN, SIGN_UP)
                },
                modifier = Modifier.padding(top = 50.dp)
            ) {
                Text("Go to Sign In")
            }
        }
    }
}

const val AUTH_GRAPH = "AuthGraph"
const val SIGN_IN = "SignIn"
const val SIGN_UP = "SignUp"
const val EMAIL_VERIFICATION = "EmailVerification"

fun NavHostController.navigateAndPopUp(
    destination: String,
    current: String
) {
    navigate(destination) {
        launchSingleTop = true
        popUpTo(current) {
            inclusive = true
        }
    }
}