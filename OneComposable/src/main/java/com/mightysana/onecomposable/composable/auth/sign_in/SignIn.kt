package com.mightysana.onecomposable.composable.auth.sign_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.mightysana.onecomposable.OneImage
import com.mightysana.onecomposable.OneValue
import com.mightysana.onecomposable.Preview
import com.mightysana.onecomposable.composable.OneButton
import com.mightysana.onecomposable.composable.OneImage
import com.mightysana.onecomposable.composable.OneTextField
import com.mightysana.onecomposable.composable.SecondaryContainerCard

@Composable
fun SignInCard(
    titleImage: @Composable () -> Unit,
    title: @Composable () -> Unit,
    emailTextField: @Composable () -> Unit,
    passwordTextField: @Composable () -> Unit,
    signInButton: @Composable () -> Unit,
    additionalContent: @Composable () -> Unit = {},
    modifier: Modifier = Modifier
) {
    SecondaryContainerCard(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(OneValue.smallPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(OneValue.padding)
                .fillMaxWidth()
        ) {
            titleImage()
            title()
            emailTextField()
            passwordTextField()
            signInButton()
            additionalContent()
        }
    }
}

@PreviewLightDark
@Composable
fun SignInCardPreview() {
    Preview {
        SignInCard(
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
                    value = "",
                    onValueChange = {},
                    label = { Text("Email") },
                    supportingText = {
                        Text("We'll never share your email.")
                    }
                )
            },
            passwordTextField = {
                OneTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Password") },
                    supportingText = {
                        Text("We'll never share your password.")
                    }
                )
            },
            signInButton = {
                OneButton(
                    onClick = {}
                ) {
                    Text("Sign In")
                }
            }
        )
    }
}