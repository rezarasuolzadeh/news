package ir.rezarasuolzadeh.news.presentation.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import ir.rezarasuolzadeh.news.presentation.ui.theme.ShimmerColorShades

@Composable
fun HomeScreenShimmer() {
    HomeScreenShimmerAnimation()
}

@Composable
fun HomeScreenShimmerAnimation() {
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 3000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 800,
                easing = FastOutSlowInEasing,
                delayMillis = 100
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = ShimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(translateAnim, translateAnim)
    )

    HomeScreenShimmerItem(brush = brush)
}

@Composable
fun HomeScreenShimmerItem(
    brush: Brush
) {
    LazyColumn {
        item {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(brush = brush)
                )

                Spacer(
                    modifier = Modifier
                        .absolutePadding(top = 20.dp)
                        .width(200.dp)
                        .height(15.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(brush = brush)
                )
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .absolutePadding(top = 50.dp, left = 40.dp, right = 5.dp)
                    .width(100.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(brush = brush),
            )
        }

        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }

        repeat(3) {
            item {
                Row(modifier = Modifier.padding(top = 20.dp, start = 40.dp)) {
                    Spacer(
                        modifier = Modifier
                            .height(120.dp)
                            .width(120.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(brush = brush)
                    )

                    Column(modifier = Modifier.padding(start = 16.dp)) {
                        Spacer(
                            modifier = Modifier
                                .absolutePadding(top = 20.dp, left = 10.dp, right = 15.dp)
                                .fillMaxWidth()
                                .height(15.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(brush = brush)
                        )

                        Spacer(
                            modifier = Modifier
                                .absolutePadding(top = 10.dp, left = 10.dp, right = 15.dp)
                                .fillMaxWidth()
                                .height(15.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(brush = brush)
                        )

                        Spacer(
                            modifier = Modifier
                                .absolutePadding(top = 20.dp, left = 10.dp, right = 15.dp)
                                .width(100.dp)
                                .height(10.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(brush = brush)
                        )
                    }
                }
            }
        }
    }
}