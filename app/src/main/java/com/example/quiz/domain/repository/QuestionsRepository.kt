package com.example.quiz.domain.repository

import com.example.quiz.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionsRepository {
    suspend fun getQuestions(): Flow<List<Question>>
    suspend fun clearQuestions()

}