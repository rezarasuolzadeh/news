package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import ir.rezarasuolzadeh.news.R
import ir.rezarasuolzadeh.news.presentation.ui.theme.Grey

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ViewError(
    tryAgainClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.no_internet),
            contentDescription = "",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
        )

        Text(
            text = "something went wrong in connecting",
            style = TextStyle(
                color = Grey,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 10.dp)
        )

        OutlinedButton(
            onClick = { tryAgainClick.invoke() },
            border = BorderStroke(1.dp, Grey),
            modifier = Modifier
                .padding(top = 20.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Grey)
        ){
            Text( text = "try again" )
        }
    }
}