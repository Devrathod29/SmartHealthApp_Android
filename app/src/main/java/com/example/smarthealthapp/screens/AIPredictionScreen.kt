package com.example.smarthealthapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AIPredictionScreen(navController: NavController) {
    var prediction by remember { mutableStateOf("No prediction yet") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AI Health Prediction") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "AI-based prediction of your health status.")

            Button(
                onClick = {
                    // Simulate AI logic
                    prediction = "Low Risk of Heart Disease"
                }
            ) {
            }
            }
                Text("Run Prediction")
            }

            Text(
                text = "Result: $prediction",
                style = MaterialTheme.typography.bodyLarge
            )
        }


