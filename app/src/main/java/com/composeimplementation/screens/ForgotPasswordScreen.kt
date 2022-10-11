package com.composeimplementation.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
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
fun ForgotPasswordScreen(context: Context,navController: NavController){

    var email by remember{ mutableStateOf("") }
    var mobileNo by remember { mutableStateOf("") }

    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(
            text = stringResource(id = R.string.forgot_pswd),
            modifier = Modifier.padding(10.dp),
            style = TextStyle(
                color = Color.Blue,
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
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
            value = mobileNo,
            onValueChange = { mobileNo = it },
            label = { Text(stringResource(id = R.string.password)) },
            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = "password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedButton(
            onClick = { sendOtp(email, mobileNo,context)
                navController.navigate(route = Screen.Login.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
//                    .clickable {
////                        navController.navigate(route = Screen.WelcomeScreen.route)
//                    }
        ) {

            Text(
                text = stringResource(id = R.string.sendOtp),
                textAlign = TextAlign.Center
            )

        }

    }

}

fun sendOtp(email: String, mobileNo: String,context: Context) {
    if (email == "" || !(email == "Kavita")){
        Toast.makeText(context,"Enter the valid Details", Toast.LENGTH_SHORT).show()
    }
    else if (mobileNo == "" || !(mobileNo == "1234567809")){
        Toast.makeText(context,"Enter the valid Details", Toast.LENGTH_SHORT).show()
    }
    else{
        Toast.makeText(context,"Otp Sent", Toast.LENGTH_SHORT).show()
    }
}


@Preview
@Composable
fun PreviewForgotScreen(){
    ForgotPasswordScreen(context = LocalContext.current,navController = rememberNavController())
}