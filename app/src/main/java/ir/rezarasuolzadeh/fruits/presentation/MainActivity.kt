package ir.rezarasuolzadeh.fruits.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import ir.rezarasuolzadeh.fruits.R
import ir.rezarasuolzadeh.fruits.presentation.ui.nav.Navigation
import ir.rezarasuolzadeh.fruits.presentation.ui.theme.FruitsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Fruits)
        setContent {
            FruitsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }

}