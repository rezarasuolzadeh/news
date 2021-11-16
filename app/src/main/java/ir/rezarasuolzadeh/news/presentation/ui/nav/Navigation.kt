package ir.rezarasuolzadeh.news.presentation.ui.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.rezarasuolzadeh.news.presentation.ui.screens.DetailScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.HomeScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.SavedScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.Screen
import ir.rezarasuolzadeh.news.viewmodel.NewsViewModel

@ExperimentalAnimationApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun Navigation(
    newsViewModel: NewsViewModel
) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        // home screen
        composable(
            route = Screen.HomeScreen.route,
            enterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { 1000 })
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { -1000 })
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { -1000 })
            },
            popExitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { 1000 })
            }
        ) {
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
            ),
            enterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { 1000 })
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { -1000 })
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { -1000 })
            },
            popExitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { 1000 })
            }
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
            ),
            enterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { 1000 })
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { -1000 })
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(initialOffsetX = { -1000 })
            },
            popExitTransition = { _, _ ->
                slideOutHorizontally(targetOffsetX = { 1000 })
            }
        ) { entry ->
            DetailScreen(
                navController = navController,
                name = entry.arguments?.getString("name")
            )
        }
    }
}