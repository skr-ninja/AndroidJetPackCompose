package com.composeimplementation.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.composeimplementation.screens.ForgotPasswordScreen
import com.composeimplementation.screens.Login
import com.composeimplementation.screens.WelcomeScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = BottomBarScreen.Login.route){
        composable(route = BottomBarScreen.Login.route){
            Login(context = LocalContext.current, navController = navController)
        }

        composable(route = BottomBarScreen.ForgotPassword.route){
            ForgotPasswordScreen(context = LocalContext.current, navController = navController)
        }

        composable(route = BottomBarScreen.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }
    }
}