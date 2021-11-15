package ir.rezarasuolzadeh.news.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import ir.rezarasuolzadeh.news.R
import ir.rezarasuolzadeh.news.presentation.ui.nav.Navigation
import ir.rezarasuolzadeh.news.presentation.ui.theme.FruitsTheme
import ir.rezarasuolzadeh.news.viewmodel.NewsViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val newsViewModel by viewModels<NewsViewModel>()

    @ExperimentalComposeUiApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Fruits)
        setContent {
            FruitsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation(
                        newsViewModel = newsViewModel
                    )
                }
            }
        }
    }

}