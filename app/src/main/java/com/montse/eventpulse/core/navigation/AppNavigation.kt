package com.montse.eventpulse.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.montse.eventpulse.features.auth.presentation.screens.LoginScreen
import com.montse.eventpulse.features.events.presentation.admin.screens.AdminDashboardScreen
import com.montse.eventpulse.features.events.presentation.staff.screens.StaffFeedScreen

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
                    // 💡 POR AHORA: Usamos un ID de evento de prueba.
                    // Más adelante, esto puede venir de tu API al loguearse.
                    val mockEventId = "evento_001"

                    if (role == "admin") {
                        navController.navigate(Screen.AdminDashboard.createRoute(mockEventId)) {
                            // Evita que el botón de "Atrás" regrese al Login
                            popUpTo(Screen.Login.route) { inclusive = true }
                        }
                    } else {
                        navController.navigate(Screen.StaffDashboard.createRoute(mockEventId)) {
                            // Evita que el botón de "Atrás" regrese al Login
                            popUpTo(Screen.Login.route) { inclusive = true }
                        }
                    }
                }
            )
        }

        // Ruta Admin
        composable(
            route = Screen.AdminDashboard.route,
            arguments = listOf(navArgument("eventId") { type = NavType.StringType })
        ) { backStackEntry ->
            // Recuperamos el ID que pasamos en la ruta
            val eventId = backStackEntry.arguments?.getString("eventId") ?: ""
            AdminDashboardScreen(eventId = eventId)
        }

        // Ruta Staff (Usando StaffFeedScreen que fue la que creamos)
        composable(
            route = Screen.StaffDashboard.route,
            arguments = listOf(navArgument("eventId") { type = NavType.StringType })
        ) { backStackEntry ->
            // Recuperamos el ID que pasamos en la ruta
            val eventId = backStackEntry.arguments?.getString("eventId") ?: ""
            StaffFeedScreen(eventId = eventId)
        }
    }
}