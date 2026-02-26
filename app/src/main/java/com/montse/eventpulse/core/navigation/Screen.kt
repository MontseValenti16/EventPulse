package com.montse.eventpulse.core.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")

    // Le indicamos que espera un parámetro {eventId}
    object AdminDashboard : Screen("admin_dashboard/{eventId}") {
        fun createRoute(eventId: String) = "admin_dashboard/$eventId"
    }

    // Lo mismo para el staff
    object StaffDashboard : Screen("staff_dashboard/{eventId}") {
        fun createRoute(eventId: String) = "staff_dashboard/$eventId"
    }

    object EventFeed : Screen("event_feed")
}