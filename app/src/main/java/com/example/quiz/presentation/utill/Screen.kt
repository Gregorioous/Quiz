package com.example.quiz.presentation.utill

sealed class Screen(val route: String) {
    object MainScreen : Screen(route = "main_screen")
    object QuestionScreen : Screen(route = "question_screen")
    object FinishScreen : Screen(route = "finish_screen")
}