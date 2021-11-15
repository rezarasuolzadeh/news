package ir.rezarasuolzadeh.news.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.rezarasuolzadeh.news.presentation.ui.component.ItemHeaderTitle
import ir.rezarasuolzadeh.news.presentation.ui.component.ItemNews
import ir.rezarasuolzadeh.news.presentation.ui.component.Pager
import ir.rezarasuolzadeh.news.presentation.ui.component.Toolbar
import ir.rezarasuolzadeh.news.presentation.ui.theme.LightGrey
import ir.rezarasuolzadeh.news.viewmodel.NewsViewModel

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun HomeScreen(
    navController: NavController,
    newsViewModel: NewsViewModel
) {
    newsViewModel.fetchHeadlineNews()
    newsViewModel.fetchTechnologyNews()

    val headlineNews by newsViewModel.headlineNewsLiveData.observeAsState(emptyList())
    val technologyNews by newsViewModel.technologyNewsLiveData.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(LightGrey),
    ) {
        Toolbar(navController)

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(LightGrey),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {

            if (headlineNews.isNotEmpty()) {
                item {
                    Pager(headlineNews)
                }
            }

            if (technologyNews.isNotEmpty()) {
                item {
                    ItemHeaderTitle("Technology News")
                }
                for (i in technologyNews.indices) {
                    item {
                        ItemNews(
                            navController = navController,
                            news = technologyNews[i]
                        )
                    }
                }
            }
        }
    }
}