package com.example.quiz.presentation.questions

import androidx.navigation.NavHostController

sealed class QuestionEvent {
    data class NextQuestion(val navHostController: NavHostController) : QuestionEvent()
    data class ChangeAnswer(val ans: String) : QuestionEvent()

    object OpenDialog : QuestionEvent()
    object CloseDialog : QuestionEvent()


}