package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import ir.rezarasuolzadeh.news.R
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.presentation.ui.screens.Screen
import ir.rezarasuolzadeh.news.presentation.ui.theme.Grey
import ir.rezarasuolzadeh.news.presentation.ui.theme.LightGrey
import ir.rezarasuolzadeh.news.presentation.ui.theme.MediumGrey
import ir.rezarasuolzadeh.news.presentation.ui.theme.RippleGrey
import ir.rezarasuolzadeh.news.utils.constants.Constants.NEWS_BUNDLE_KEY
import ir.rezarasuolzadeh.news.utils.extentions.putParcelableBundle
import ir.rezarasuolzadeh.news.utils.library.paintImage

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ItemNews(
    news: NewsModel,
    navController: NavController
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightGrey)
    ) {
        val (card, image) = createRefs()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(123.dp)
                .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
                .background(Color.White)
                .constrainAs(card) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start, margin = 50.dp)
                }
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = RippleGrey),
                    onClick = {
                        navController.putParcelableBundle(key = NEWS_BUNDLE_KEY, value = news)
                        navController.navigate(Screen.DetailScreen.withArgs("ali"))
                    }
                )
        ) {
            Text(
                text = news.title,
                style = TextStyle(
                    color = Grey,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp,
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 120.dp, end = 60.dp, top = 15.dp)
            )

            Text(
                text = news.sourceModel?.name.orEmpty(),
                style = TextStyle(
                    color = MediumGrey,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 10.sp,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 120.dp, end = 60.dp, top = 15.dp)
            )
        }

        Image(
            painter = paintImage(image = news.image),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(120.dp, 120.dp)
                .clip(RoundedCornerShape(5.dp))
                .constrainAs(image) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 30.dp)
                }
        )
    }
}