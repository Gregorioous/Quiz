package com.example.quiz.presentation.utill

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.presentation.finish.FinishScreen
import com.example.quiz.presentation.main.MainScreen
import com.example.quiz.presentation.questions.QuestionScreen

@Composable
fun Navigathion() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(
            route = Screen.MainScreen.route,
        ) {
            MainScreen(navHostController = navController)
        }

        composable(
            route = Screen.QuestionScreen.route,
        ) {
            QuestionScreen(navHostController = navController)
        }

        composable(
            route = Screen.FinishScreen.route,
        ) {
            FinishScreen(navHostController = navController)
        }
    }


}