package ir.rezarasuolzadeh.news.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.presentation.ui.component.ToolbarDetail
import ir.rezarasuolzadeh.news.presentation.ui.theme.LightGrey
import ir.rezarasuolzadeh.news.utils.constants.Constants.NEWS_BUNDLE_KEY
import ir.rezarasuolzadeh.news.utils.extentions.getParcelableBundle
import ir.rezarasuolzadeh.news.utils.extentions.toast

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun DetailScreen(
    navController: NavController,
    name: String?
) {
    val context = LocalContext.current
    var news : NewsModel?

    LaunchedEffect(Unit) {
        news = navController.getParcelableBundle(NEWS_BUNDLE_KEY) as NewsModel
        context.toast(news?.title)
    }

    Column(
        modifier = Modifier
            .background(LightGrey)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ToolbarDetail(navController = navController)
    }

}