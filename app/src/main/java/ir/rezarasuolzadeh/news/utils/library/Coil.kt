package ir.rezarasuolzadeh.news.utils.library

import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import ir.rezarasuolzadeh.news.R

@ExperimentalCoilApi
@Composable
fun paintImage(image: String): ImagePainter {
    return rememberImagePainter(
        data = image,
        builder = {
            placeholder(R.drawable.placeholder)
            error(R.drawable.placeholder)
        }
    )
}