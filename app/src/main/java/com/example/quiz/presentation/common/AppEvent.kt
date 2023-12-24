package com.example.quiz.presentation.common

sealed class AppEvent {
    object ClearCache : AppEvent()
}