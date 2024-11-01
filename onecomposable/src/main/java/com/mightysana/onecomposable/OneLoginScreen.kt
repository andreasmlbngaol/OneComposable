package com.mightysana.onecomposable

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tsunami
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun OneTsunamiIcon(
    icon: Icon
) {
    Icon(
        imageVector = Icons.Default.Tsunami,
        contentDescription = "Tsunami Icon"
    )
}