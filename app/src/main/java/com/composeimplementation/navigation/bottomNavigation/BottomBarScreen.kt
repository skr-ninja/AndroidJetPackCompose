package com.composeimplementation.navigation.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Login : BottomBarScreen(
            route ="login",
        title = "Login",
        icon = Icons.Default.Home
    )

    object ForgotPassword : BottomBarScreen(
        route ="forgot_password",
        title = "ForgotPassword",
        icon = Icons.Default.Info
    )

    object WelcomeScreen : BottomBarScreen(
        route ="welcome_screen",
        title = "Welcome Screen",
        icon = Icons.Default.Settings
    )
}

