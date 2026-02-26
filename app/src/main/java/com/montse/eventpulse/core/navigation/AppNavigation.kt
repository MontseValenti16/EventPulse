package com.montse.eventpulse.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.montse.eventpulse.features.auth.presentation.screens.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        // Ruta Login
        composable(Screen.Login.route) {

            LoginScreen(
                 onLoginSuccess = { role ->
                    if (role == "admin") navController.navigate(Screen.AdminDashboard.route)
                     else navController.navigate(Screen.StaffDashboard.route)
                 }
             )
        }

        // Ruta Admin
        composable(Screen.AdminDashboard.route) {
            // AdminDashboardScreen()
        }

        // Ruta Staff
        composable(Screen.StaffDashboard.route) {
            // StaffDashboardScreen()
        }
    }
}