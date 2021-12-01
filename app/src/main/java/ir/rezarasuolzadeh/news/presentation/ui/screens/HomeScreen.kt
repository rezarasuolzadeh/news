package ir.rezarasuolzadeh.news.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.rezarasuolzadeh.news.presentation.ui.component.*
import ir.rezarasuolzadeh.news.presentation.ui.theme.LightGrey
import ir.rezarasuolzadeh.news.viewmodel.NewsViewModel

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun HomeScreen(
    navController: NavController,
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    var initialApiCalled by rememberSaveable { mutableStateOf(false) }

    if (!initialApiCalled) {
        LaunchedEffect(Unit) {
            newsViewModel.fetchHeadlineNews()
            initialApiCalled = true
        }
    }

    val headlineNews by newsViewModel.headlineNewsLiveData.observeAsState(emptyList())
    val error by newsViewModel.errorLiveData.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(LightGrey),
    ) {
        ToolbarHome(navController)

        if (error) {
            ViewError()
        } else {
            if (headlineNews.isEmpty()) {
                HomeScreenShimmer()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(LightGrey),
                    contentPadding = PaddingValues(bottom = 20.dp)
                ) {

                    if (headlineNews.isNotEmpty()) {
                        item {
                            Pager(
                                newsList = headlineNews,
                                navController = navController
                            )
                        }
                    }

                    if (headlineNews.isNotEmpty()) {
                        item {
                            ItemHeaderTitle("Technology News")
                        }
                        for (i in headlineNews.indices) {
                            item {
                                ItemNews(
                                    navController = navController,
                                    news = headlineNews[i]
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}