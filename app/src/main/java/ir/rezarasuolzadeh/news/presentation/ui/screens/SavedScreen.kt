package ir.rezarasuolzadeh.news.presentation.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.rezarasuolzadeh.news.presentation.ui.component.ItemSavedNews
import ir.rezarasuolzadeh.news.presentation.ui.component.ToolbarSaved
import ir.rezarasuolzadeh.news.presentation.ui.component.ViewEmpty
import ir.rezarasuolzadeh.news.presentation.ui.theme.LightGrey
import ir.rezarasuolzadeh.news.viewmodel.SavedViewModel

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun SavedScreen(
    navController: NavController,
    name: String?,
    savedViewModel: SavedViewModel = hiltViewModel()
) {
    val savedNews by savedViewModel.savedNewsLiveData.observeAsState(listOf())

    savedViewModel.fetchSavedNews()

    Column(
        modifier = Modifier
            .background(LightGrey)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ToolbarSaved(navController = navController)

        if (savedNews.isEmpty())
            ViewEmpty()
        else
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(LightGrey),
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            ) {
                savedNews.map {
                    item {
                        ItemSavedNews(
                            news = it,
                            navController = navController
                        )
                    }
                }
            }
    }
}