package ir.rezarasuolzadeh.news.presentation.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.rezarasuolzadeh.news.presentation.ui.screens.DetailScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.SavedScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.HomeScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.Screen
import ir.rezarasuolzadeh.news.viewmodel.NewsViewModel

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun Navigation(
    newsViewModel: NewsViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        // home screen
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                newsViewModel = newsViewModel
            )
        }

        // saved screen
        composable(
            route = Screen.SavedScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Reza"
                    nullable = true
                }
            )
        ) { entry ->
            SavedScreen(
                navController = navController,
                name = entry.arguments?.getString("name")
            )
        }

        // detail screen
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Reza"
                    nullable = true
                }
            )
        ) { entry ->
            DetailScreen(
                navController = navController,
                name = entry.arguments?.getString("name")
            )
        }
    }
}