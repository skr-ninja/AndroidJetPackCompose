package com.composeimplementation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.composeimplementation.navigation.setupNavGraph


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // rememberNavController allows us to immediately create NavHostController
            // which will handle Navigation in our app
            navController = rememberNavController()
            setupNavGraph(navController = navController)
        }
    }
}