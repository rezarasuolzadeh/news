package ir.rezarasuolzadeh.fruits.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import ir.rezarasuolzadeh.fruits.ui.screens.HomeScreen
import ir.rezarasuolzadeh.fruits.ui.screens.LoginScreen
import ir.rezarasuolzadeh.fruits.ui.screens.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.HomeScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Reza"
                    nullable = true
                }
            )
        ) { entry ->
            HomeScreen(name = entry.arguments?.getString("name"))
        }
    }
}