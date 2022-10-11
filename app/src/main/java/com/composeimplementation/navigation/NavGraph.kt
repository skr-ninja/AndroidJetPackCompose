package com.composeimplementation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.composeimplementation.screens.*

// NavigationHost File
@Composable
fun setupNavGraph(navController: NavHostController){

    NavHost(navController = navController,
        startDestination = Screen.SplashScreen.route    // or we can write "login_screen"
    ){
// Inside NavgraphBuilder, we will specify our destinations
        composable(
            route =Screen.SplashScreen.route
        ){
            SplashScreen(navController = navController)
        }

        composable(
            route =Screen.Login.route
        ){
            Login(context = LocalContext.current, navController = navController)
        }

        composable(
            route =  Screen.ForgotPassword.route
        ){
            ForgotPasswordScreen(context = LocalContext.current, navController = navController)
        }

        composable(
            route =Screen.WelcomeScreen.route,
            arguments = listOf(navArgument("$ARGUMENT_KEY1"){
                type= NavType.StringType
            },
                navArgument("$ARGUMENT_KEY2"){
                    type= NavType.StringType
                })
        ){
            Log.d("Args",it.arguments?.getString(ARGUMENT_KEY1).toString())
            Log.d("Args",it.arguments?.getString(ARGUMENT_KEY2).toString())
            WelcomeScreen(navController = navController)
        }
    }
}
