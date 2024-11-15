package com.mightysana.onecomposable.composable.auth.sign_in

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.mightysana.onecomposable.OneImage
import com.mightysana.onecomposable.OneValue
import com.mightysana.onecomposable.R
import com.mightysana.onecomposable.composable.OneButton
import com.mightysana.onecomposable.composable.OneIcon
import com.mightysana.onecomposable.composable.OneIcons
import com.mightysana.onecomposable.composable.OneImage
import com.mightysana.onecomposable.composable.OneImageButton
import com.mightysana.onecomposable.composable.OneTextField
import com.mightysana.onecomposable.composable.SurfaceVariantTextHorizontalDivider
import com.mightysana.onecomposable.composable.TertiaryTextButton
import com.mightysana.onecomposable.model.navigateAndPopUp
import com.mightysana.onecomposable.viewmodel.SignInViewModel
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(
    navController: NavHostController,
    mainRoute: String,
    defaultWebClientId: String,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val visible = viewModel.visible.collectAsState().value
    val isEmailError = viewModel.isEmailError.collectAsState().value
    val isPasswordError = viewModel.isPasswordError.collectAsState().value
    val coroutineScope = rememberCoroutineScope()
    val credentialManager = CredentialManager.create(context)

    Scaffold { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(OneValue.padding)
        ) {
            SignInCard(
                modifier = Modifier
                    .padding(innerPadding)
                    .widthIn(max = 350.dp),
                titleImage = {
                    OneImage(
                        OneImage.LauncherIcon,
                        modifier = Modifier
                            .width(100.dp)
                            .aspectRatio(1f)
                    )
                },
                title = {
                    Text(
                        "Sign In",
                        style = MaterialTheme.typography.headlineMedium,
                        textDecoration = TextDecoration.Underline
                    )
                },
                emailTextField = {
                    OneTextField(
                        isError = isEmailError,
                        leadingIcon = {
                            OneIcon(OneIcons.Email)
                        },
                        value = viewModel.email.collectAsState().value,
                        onValueChange = { viewModel.updateEmail(it) },
                        label = { Text("Email") },
                        supportingText = {
                            AnimatedVisibility(isEmailError) {
                                Text(viewModel.emailErrorMessage.collectAsState().value ?: "")
                            }
                        },
                        modifier = Modifier.fillMaxSize(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )
                },
                passwordTextField = {
                    OneTextField(
                        isError = isPasswordError,
                        leadingIcon = {
                            OneIcon(OneIcons.Password)
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    viewModel.togglePasswordVisibility()
                                }
                            ) {
                                AnimatedContent(visible, label = "") {
                                    OneIcon(
                                        if (!it) OneIcons.PasswordVisible else OneIcons.PasswordNotVisible
                                    )
                                }
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation = if(!visible) PasswordVisualTransformation() else VisualTransformation.None,
                        value = viewModel.password.collectAsState().value,
                        onValueChange = { viewModel.updatePassword(it) },
                        label = { Text("Password") },
                        supportingText = {
                            AnimatedVisibility(isPasswordError) {
                                Text(viewModel.passwordErrorMessage.collectAsState().value ?: "")
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                },
                signInButton = {
                    OneButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            viewModel.validateSignInForm {
                                navController.navigateAndPopUp(mainRoute, "SignIn")
                            }
                        }
                    ) {
                        Text("Sign In")
                    }
                },
                additionalContent = {
                    SurfaceVariantTextHorizontalDivider(
                        text = "or continue with"
                    )
                    OneImageButton(
                        {
                            val googleIdOption = GetGoogleIdOption.Builder()
                                .setFilterByAuthorizedAccounts(false)
                                .setServerClientId(defaultWebClientId)
                                .build()

                            val request = GetCredentialRequest.Builder()
                                .addCredentialOption(googleIdOption)
                                .build()

                            coroutineScope.launch {
                                try {
                                    val result = credentialManager.getCredential(
                                        request = request,
                                        context = context
                                    )
                                    viewModel.onSignInWithGoogle(result.credential) {
                                        navController.navigateAndPopUp(it, "SignIn")
                                    }
                                } catch (e: Exception) {
                                    Log.e("GoogleAuthButton", "Error getting credential", e)
                                }
                            }

                        },
                        painterResource(R.drawable.loader_image),
                        width = 40.dp,
                        height = 40.dp
                    )
                    TertiaryTextButton(
                        onClick = {
                            navController.navigateAndPopUp("SignUp", "SignIn")
                        }
                    ) { Text("Go to Sign Up") }
                }
            )
        }
    }
}