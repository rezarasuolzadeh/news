package ir.rezarasuolzadeh.fruits.ui.screens

sealed class Screen (val route: String) {
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
