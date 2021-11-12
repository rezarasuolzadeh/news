package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.presentation.ui.theme.LightGrey
import ir.rezarasuolzadeh.news.presentation.ui.theme.MediumGrey
import ir.rezarasuolzadeh.news.presentation.ui.theme.RippleWhite

@ExperimentalCoilApi
@Composable
fun ItemHeaderPager(
    news: NewsModel
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
            .background(LightGrey)
    ) {
        val (image, time, title) = createRefs()
        val painter = rememberImagePainter(data = news.image)
        Image(
            painter = painter,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(20.dp))
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = RippleWhite),
                    onClick = {/*nothing to do*/}
                )
        )

        Text(
            text = news.title,
            style = TextStyle(
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 22.sp,
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .width(200.dp)
                .constrainAs(title) {
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
        )

        Text(
            text = news.sourceModel?.name.orEmpty(),
            style = TextStyle(
                color = MediumGrey,
                fontFamily = FontFamily.SansSerif,
                fontSize = 10.sp,
            ),
            modifier = Modifier
                .constrainAs(time) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
        )
    }
}