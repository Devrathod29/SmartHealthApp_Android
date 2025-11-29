package com.example.smarthealthapp.navigation

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smarthealthapp.auth.AuthViewModel
import com.example.smarthealthapp.screens.*
import com.google.android.gms.auth.api.signin.GoogleSignInClient

@Composable
fun AppNavigation(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    googleSignInClient: GoogleSignInClient,
    googleSignInLauncher: ActivityResultLauncher<Intent>
) {
    NavHost(navController, startDestination = "signup") {
        composable("login") {
            LoginScreen(
                navController = navController,
                viewModel = authViewModel,
                googleSignInClient = googleSignInClient,
                googleSignInLauncher = googleSignInLauncher
            )
        }
        composable("signup") {
            SignUpScreen(
                navController = navController,
                viewModel = authViewModel
            )
        }
        composable("dashboard") {
            DashboardScreen(navController)
        }
        composable("ai_prediction") {
            AIPredictionScreen(navController)
        }
        composable("emergency_alert") {
            EmergencyAlertScreen(navController)
        }
    }
}
