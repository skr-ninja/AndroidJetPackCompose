package com.composeimplementation.navigation.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Login : BottomBarScreen(
            route ="login",
        title = "Home",
        icon = Icons.Default.Home
    )

    object ForgotPassword : BottomBarScreen(
        route ="forgot_password",
        title = "DashBoard",
        icon = Icons.Default.Info
    )

    object WelcomeScreen : BottomBarScreen(
        route ="welcome_screen",
        title = "Settings",
        icon = Icons.Default.Settings
    )

    object SplashScreen: BottomBarScreen(
        route = "splash_screen",
        title = "Profile",
        icon = Icons.Default.Phone
    )
}

