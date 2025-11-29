package com.example.smarthealthapp.google

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GoogleSignInButton(
    onSignInClick: () -> Unit
) {
    Button(
        onClick = onSignInClick,
        modifier = Modifier,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Text("Sign in with Google")
    }
}
