package com.example.smarthealthapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Smart Health Dashboard") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to your Health Dashboard",
                style = MaterialTheme.typography.headlineSmall
            )

            Button(
                onClick = { navController.navigate("ai_prediction") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("AI Health Prediction")
            }

            Button(
                onClick = { navController.navigate("emergency_alert") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Emergency Alert")
            }
        }
    }
}
