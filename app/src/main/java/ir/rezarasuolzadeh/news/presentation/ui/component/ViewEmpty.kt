package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import ir.rezarasuolzadeh.news.R
import ir.rezarasuolzadeh.news.presentation.ui.theme.Grey

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun ViewEmpty() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.no_content),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(70.dp, 70.dp)
        )

        Text(
            text = "no news saved",
            style = TextStyle(
                color = Grey,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}