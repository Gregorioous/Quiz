package com.example.quiz.presentation.questions

import com.example.quiz.domain.model.Question

data class QuestionState(
    val questionNo: Int? = 0,
    val currQuestion: Question? = Question(
        category = "",
        id = "",
        correctAnswer = "",
        answers = listOf(),
        tags = listOf(),
        question = "",
        type = "",
        difficulty = "",
        regions = null,
        isNiche = false
    ),
    val isEnabled: Boolean = true,
    val currAns: String = "",

    )