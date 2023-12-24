package com.example.quiz.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz.domain.repository.QuestionsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository,
) : ViewModel() {

    fun onEvent(event: AppEvent) {
        when (event) {
            is AppEvent.ClearCache -> {
                viewModelScope.launch {
                    questionsRepository.clearQuestions()
                }
            }
        }
    }
}