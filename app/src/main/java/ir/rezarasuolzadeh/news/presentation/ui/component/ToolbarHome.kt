package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import ir.rezarasuolzadeh.news.R
import ir.rezarasuolzadeh.news.presentation.ui.screens.Screen
import ir.rezarasuolzadeh.news.presentation.ui.theme.MediumGrey

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ToolbarHome(
    navController: NavController
) {
    Column {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(White)
        ) {
            val (profileImage, logoImage, favoriteImage) = createRefs()

            Image(
                painter = painterResource(R.drawable.ic_profile),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(25.dp, 25.dp)
                    .constrainAs(profileImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 30.dp)
                    }

            )

            Image(
                painter = painterResource(R.drawable.news),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(70.dp, 60.dp)
                    .constrainAs(logoImage) {
                        top.linkTo(parent.top, margin = 5.dp)
                        bottom.linkTo(parent.bottom, margin = 5.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
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
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            navController.navigate(Screen.SavedScreen.withArgs("ali"))
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