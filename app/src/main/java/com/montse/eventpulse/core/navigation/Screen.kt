package com.montse.eventpulse.core.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object AdminDashboard : Screen("admin_dashboard")
    object StaffDashboard : Screen("staff_dashboard")
    object EventFeed : Screen("event_feed")
}