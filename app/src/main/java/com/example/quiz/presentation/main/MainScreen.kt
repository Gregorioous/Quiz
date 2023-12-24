package com.example.quiz.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.quiz.R
import com.example.quiz.presentation.utill.Screen


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.question),
            contentDescription = stringResource(R.string.logo)
        )
        Text(text = stringResource(R.string.moto))
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .background(Color(0xFF790252).copy(0.5f))
                .padding(16.dp)

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.best_of_all_time),
                    color = Color.White.copy(0.7f)
                )
                Text(text = viewModel.points.value.toString(), fontSize = 64.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navHostController.navigate(Screen.QuestionScreen.route) {

                    popUpTo(navHostController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAF0171).copy(0.7f))
        ) {
            Text(text = stringResource(id = R.string.play))
        }


    }
}