package ir.rezarasuolzadeh.news.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.rezarasuolzadeh.news.R
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.presentation.ui.component.ToolbarDetail
import ir.rezarasuolzadeh.news.presentation.ui.theme.Grey
import ir.rezarasuolzadeh.news.presentation.ui.theme.MediumGrey
import ir.rezarasuolzadeh.news.utils.extentions.removeExtraChars
import ir.rezarasuolzadeh.news.utils.intents.Intents
import ir.rezarasuolzadeh.news.utils.library.paintImage
import ir.rezarasuolzadeh.news.viewmodel.DetailViewModel

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun DetailScreen(
    navController: NavController,
    name: String?,
    news: NewsModel?,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val existNews by detailViewModel.existNewsLiveData.observeAsState(false)

    detailViewModel.fetchExistNews(news?.url.orEmpty())

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ToolbarDetail(
            navController = navController,
            url = news?.url.orEmpty()
        )

        Image(
            painter = paintImage(image = news?.image.orEmpty()),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(MediumGrey)
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color.White)
        ) {
            val (savedButton, sourceName) = createRefs()

            Text(
                text = news?.sourceModel?.name.orEmpty(),
                style = TextStyle(
                    color = MediumGrey,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 10.sp
                ),
                modifier = Modifier
                    .padding(start = 30.dp)
                    .constrainAs(sourceName) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            Intents.openUrlIntent(
                                context = context,
                                url = news?.sourceModel?.url.orEmpty()
                            )
                        }
                    )
            )
            Image(
                painter = if (existNews) painterResource(R.drawable.ic_saved_fill) else painterResource(
                    R.drawable.ic_saved
                ),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(23.dp, 23.dp)
                    .constrainAs(savedButton) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end, margin = 30.dp)
                    }
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            news?.let {
                                if (existNews)
                                    detailViewModel.fetchDeleteNews(it)
                                else
                                    detailViewModel.fetchSaveNews(it)
                            }
                        }
                    )
            )
        }

        Text(
            text = news?.title.orEmpty(),
            style = TextStyle(
                color = Grey,
                fontFamily = FontFamily.SansSerif,
                fontSize = 18.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 15.dp)
        )

        Text(
            text = news?.description.plus(news?.content?.removeExtraChars()),
            style = TextStyle(
                color = Grey,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 15.dp)
        )
    }

}