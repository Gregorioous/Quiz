package com.example.quiz.presentation.questions

import com.example.quiz.domain.model.Question

data class QuestionListState(
    val list: MutableList<Question> = mutableListOf(),
    val tempPoints: Int = 0,
    val points: Int = 0
)