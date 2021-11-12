package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.rezarasuolzadeh.news.presentation.ui.theme.LightGrey

@Preview(showBackground = true)
@Composable
fun ItemHeaderTitle(title: String = "Title") {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 10.dp, 10.dp, 10.dp)
            .background(LightGrey),
        fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif
    )
}