package com.composeimplementation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.composeimplementation.navigation.Screen

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Screen.Login.route){
                    // In case when we want to send some data from second screen to first
                    popUpTo(Screen.Login.route){
                        inclusive= true
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome User",
            color = Color.Blue,
            fontSize = 24.sp
        )
    }
}