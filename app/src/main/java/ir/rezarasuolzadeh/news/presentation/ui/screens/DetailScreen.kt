package ir.rezarasuolzadeh.news.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.presentation.ui.component.ToolbarDetail
import ir.rezarasuolzadeh.news.presentation.ui.theme.Grey
import ir.rezarasuolzadeh.news.presentation.ui.theme.MediumGrey
import ir.rezarasuolzadeh.news.utils.constants.Constants.NEWS_BUNDLE_KEY
import ir.rezarasuolzadeh.news.utils.extentions.getParcelableBundle
import ir.rezarasuolzadeh.news.utils.extentions.removeExtraChars
import ir.rezarasuolzadeh.news.utils.intents.Intents
import ir.rezarasuolzadeh.news.utils.library.paintImage

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun DetailScreen(
    navController: NavController,
    name: String?
) {

    val context = LocalContext.current
    val news: NewsModel? = navController.getParcelableBundle(NEWS_BUNDLE_KEY) as NewsModel?

    news?.let {
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
                url = it.url
            )

            Image(
                painter = paintImage(image = news.image),
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

            Text(
                text = it.sourceModel?.name.orEmpty(),
                style = TextStyle(
                    color = MediumGrey,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 10.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, top = 15.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            Intents.openUrlIntent(
                                context = context,
                                url = it.sourceModel?.url.orEmpty()
                            )
                        }
                    )
            )

            Text(
                text = it.title,
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
                text = it.description.plus(it.content.removeExtraChars()),
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
}