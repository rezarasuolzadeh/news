package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.rezarasuolzadeh.news.presentation.ui.theme.Grey
import ir.rezarasuolzadeh.news.presentation.ui.theme.LightGrey

@Composable
fun ItemHeaderTitle(title: String = "Title") {
    Text(
        text = title,
        style = TextStyle(
            color = Grey,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 10.dp, 10.dp, 10.dp)
            .background(LightGrey),
        fontFamily = FontFamily.SansSerif
    )
}