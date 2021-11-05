package ir.rezarasuolzadeh.news.presentation.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.rezarasuolzadeh.news.viewmodel.NewsViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    newsViewModel: NewsViewModel
) {
    newsViewModel.fetchHeadlineNews()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {
                navController.navigate(Screen.HomeScreen.withArgs("ali"))
            },
            modifier = Modifier.padding(all = Dp(10F)),
            enabled = true,
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
            shape = MaterialTheme.shapes.medium,
        )
        {
            Text(text = "Go to home page", color = Color.White)
        }
    }
}