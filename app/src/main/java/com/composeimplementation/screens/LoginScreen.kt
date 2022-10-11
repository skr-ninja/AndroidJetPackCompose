package com.composeimplementation.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.composeimplementation.R
import com.composeimplementation.navigation.Screen

@Composable
fun Login(context: Context, navController: NavController) {
    var email by remember{ mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        Column(
            modifier = Modifier.padding(vertical = 180.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(10.dp),
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(stringResource(id = R.string.user_name)) },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "person") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(stringResource(id = R.string.password)) },
                leadingIcon = { Icon(Icons.Default.Info, contentDescription = "password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            OutlinedButton(
                onClick = { logged(email, password, context)
                    navController.navigate(route = Screen.WelcomeScreen.passNameAndPswd(name = email, password = password))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
//                    .clickable {
////                        navController.navigate(route = Screen.WelcomeScreen.route)
//                    }
            ) {

                Text(
                    text = stringResource(id = R.string.login),
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}

fun logged(email: String, password: String, context: Context) {
    if (email == "" || !(email== "Kavita")){
        Toast.makeText(context,"Login Failed", Toast.LENGTH_SHORT).show()
    }
    if (password == "" || !(password== "123456") ){
        Toast.makeText(context,"Login Failed", Toast.LENGTH_SHORT).show()
    }
    else{
        Toast.makeText(context,"Logged In", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login(context = LocalContext.current, navController = rememberNavController())
}