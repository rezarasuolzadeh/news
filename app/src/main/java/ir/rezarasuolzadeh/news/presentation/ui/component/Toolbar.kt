package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.annotation.ExperimentalCoilApi
import ir.rezarasuolzadeh.news.R
import ir.rezarasuolzadeh.news.presentation.ui.theme.MediumGrey

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun Toolbar() {
    Column {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(White)
        ) {
            val (favoriteImage, logoImage, elevation) = createRefs()

            Image(
                painter = painterResource(R.drawable.news),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(70.dp, 60.dp)
                    .constrainAs(logoImage) {
                        top.linkTo(parent.top, margin = 5.dp)
                        bottom.linkTo(parent.bottom, margin = 5.dp)
                        start.linkTo(parent.start, margin = 30.dp)
                    }
            )

            Image(
                painter = painterResource(R.drawable.ic_saved),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(25.dp, 25.dp)
                    .constrainAs(favoriteImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end, margin = 30.dp)
                    }
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