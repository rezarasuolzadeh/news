package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import ir.rezarasuolzadeh.news.R
import ir.rezarasuolzadeh.news.presentation.ui.theme.Grey
import ir.rezarasuolzadeh.news.presentation.ui.theme.MediumGrey
import ir.rezarasuolzadeh.news.utils.intents.Intents

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ToolbarDetail(
    navController: NavController,
    url: String
) {

    val context = LocalContext.current

    Column {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(White)
        ) {
            val (backImage, titleText, shareImage) = createRefs()

            Image(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(17.dp, 17.dp)
                    .constrainAs(backImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 30.dp)
                    }
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { navController.navigateUp() }
                    )
            )

            Text(
                text = "Detail",
                style = TextStyle(
                    color = Grey,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp,
                ),
                modifier = Modifier
                    .constrainAs(titleText) {
                        top.linkTo(parent.top, margin = 5.dp)
                        bottom.linkTo(parent.bottom, margin = 5.dp)
                        start.linkTo(backImage.end, margin = 10.dp)
                    }
            )

            Image(
                painter = painterResource(R.drawable.ic_share),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(25.dp, 25.dp)
                    .constrainAs(shareImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end, margin = 30.dp)
                    }
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            Intents.shareUrlIntent(
                                context = context,
                                url = url
                            )
                        }
                    )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(MediumGrey)
        )
    }
}