package com.composeimplementation.navigation

const val ARGUMENT_KEY1 = "name"
const val ARGUMENT_KEY2 = "password"

sealed class Screen(val route: String){
    object SplashScreen:Screen("splash_screen")
    // Screen Holder Class
    object Login:Screen(route = "login_screen")
    object WelcomeScreen: Screen(route = "welcome_screen/{$ARGUMENT_KEY1}/{$ARGUMENT_KEY2}"){
//        fun passName(name: String): String{
//            // this.route is written to avoid writing welcome_screen/ again and again
//            return this.route.replace("{$ARGUMENT_KEY1}", name.toString())
//        }

        fun passNameAndPswd(name: String,password: String): String{
            return "welcome_screen/$name/$password"
        }
    }
}
