package ir.rezarasuolzadeh.fruits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import ir.rezarasuolzadeh.fruits.ui.nav.Navigation
import ir.rezarasuolzadeh.fruits.ui.screens.LoginScreen
import ir.rezarasuolzadeh.fruits.ui.theme.FruitsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
//            FruitsTheme {
//                Surface(color = MaterialTheme.colors.background) {
//                    LoginScreen()
//                }
//            }
        }
    }
}