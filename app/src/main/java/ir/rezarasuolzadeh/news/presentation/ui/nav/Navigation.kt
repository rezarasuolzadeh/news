package ir.rezarasuolzadeh.news.presentation.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import ir.rezarasuolzadeh.news.presentation.ui.screens.HomeScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.LoginScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.Screen
import ir.rezarasuolzadeh.news.viewmodel.NewsViewModel

@Composable
fun Navigation(
    newsViewModel: NewsViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(
                navController = navController,
                newsViewModel = newsViewModel
            )
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