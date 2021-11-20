package ir.rezarasuolzadeh.news.presentation.ui.nav

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.presentation.ui.screens.DetailScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.HomeScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.SavedScreen
import ir.rezarasuolzadeh.news.presentation.ui.screens.Screen
import ir.rezarasuolzadeh.news.utils.constants.Constants
import ir.rezarasuolzadeh.news.utils.extentions.getParcelableBundle
import ir.rezarasuolzadeh.news.viewmodel.NewsViewModel
import ir.rezarasuolzadeh.news.viewmodel.SavedNewsViewModel

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        // home screen
        composable(
            route = Screen.HomeScreen.route,
            exitTransition = { _, target ->
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = { initial, _ ->
                slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            }
        ) {
            HomeScreen(
                navController = navController,
//                newsViewModel = newsViewModel
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
            enterTransition = { initial, _ ->
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = { _, target ->
                slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))
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
            enterTransition = { initial, _ ->
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = { _, target ->
                slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))
            }
        ) { entry ->
            DetailScreen(
                navController = navController,
                name = entry.arguments?.getString("name"),
                news = navController.getParcelableBundle(Constants.NEWS_BUNDLE_KEY) as NewsModel?
            )
        }
    }
}