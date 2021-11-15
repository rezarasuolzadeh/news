package ir.rezarasuolzadeh.news.presentation.ui.screens

sealed class Screen (val route: String) {
    object HomeScreen : Screen("home_screen")
    object SavedScreen : Screen("saved_screen")
    object DetailScreen : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
