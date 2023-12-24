package com.example.quiz.data.repository

import com.example.quiz.data.data_source.local.QuestionCacheDao
import com.example.quiz.data.data_source.remote.Services
import com.example.quiz.domain.model.Question
import com.example.quiz.domain.repository.QuestionsRepository
import kotlinx.coroutines.flow.Flow

class QuestionsRepositoryImpl(
    private val dao: QuestionCacheDao,
    private val triviaService: Services
) : QuestionsRepository {

    override suspend fun getQuestions(): Flow<List<Question>> {

        triviaService.getQuestions().forEach {
            dao.insertQuestion(
                Question(
                    id = it.id,
                    category = it.category,
                    correctAnswer = it.correctAnswer,
                    answers = (it.incorrectAnswers + it.correctAnswer).shuffled(),
                    question = it.question,
                    tags = it.tags,
                    type = it.type,
                    difficulty = it.difficulty,
                    regions = it.regions,
                    isNiche = it.isNiche
                )
            )

        }
        return dao.getQuestions()
    }


    override suspend fun clearQuestions() {
        dao.clear()
    }
}