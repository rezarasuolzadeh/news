package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.*
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.presentation.ui.theme.LightGrey
import ir.rezarasuolzadeh.news.presentation.ui.theme.MediumGrey
import ir.rezarasuolzadeh.news.presentation.ui.theme.Yellow
import kotlin.math.absoluteValue

@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun Pager(
    newsList: List<NewsModel>,
    navController: NavController
) {
    val pagerState = rememberPagerState(
        pageCount = newsList.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0,
    )

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .background(LightGrey)
                .padding(top = 25.dp, bottom = 15.dp)
        ) { index ->
            Column(
                Modifier.graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(index).absoluteValue

                    lerp(
                        start = ScaleFactor(0.55f, 0.55f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale.scaleX
                        scaleY = scale.scaleY
                    }

                    alpha = lerp(
                        start = ScaleFactor(0.5f, 0.5f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).scaleX
                },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ItemHeaderPager(
                    news = newsList[index],
                    navController = navController
                )
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = Yellow,
            inactiveColor = MediumGrey,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(LightGrey)
                .padding(16.dp)
        )
    }
}